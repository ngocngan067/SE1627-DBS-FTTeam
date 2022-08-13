package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.models.Dentist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentistFacade extends AbstractDentist<Dentist> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_TOTAL_DENTIST = "SELECT COUNT(*) FROM Dentists";
    private static final String SQL_INSERT_DENTIST = "INSERT INTO Dentists(DentistID, YearsOfExp, Skills, Salary, Insurance, DescriptionDentist) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DENTIST = "UPDATE Dentists SET YearsOfExp = ?, Skills = ?, Salary = ?, Insurance = ?, DescriptionDentist = ? WHERE DentistID = ?";
//    private static final String SQL_GET_PAGING_DENTIST = "SELECT * FROM Dentists ORDER BY DentistID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_PAGING_DENTIST = "SELECT * FROM Dentists ORDER BY DentistID LIMIT 5 OFFSET ?;";
//    private static final String SQL_GET_TOP_4_DENTIST = "SELECT TOP 4 * FROM Dentists";
    private static final String SQL_GET_TOP_4_DENTIST = "SELECT * FROM Dentists ORDER BY RAND() LIMIT 4;";
    private static final String SQL_GET_ALL_DENTIST = "SELECT * FROM Dentists";
    private static final String SQL_GET_DENTIST_DETAIL_BY_ID = "SELECT * FROM Dentists WHERE DentistID = ?";

    private Dentist getInfoDentistFromSQL(ResultSet resultSet) throws SQLException {
        String getDentistID = resultSet.getString("DentistID");
        int getYearsOfExp = resultSet.getInt("YearsOfExp");
        String getSkills = resultSet.getString("Skills");
        double getSalary = resultSet.getDouble("Salary");
        double getInsurance = resultSet.getDouble("Insurance");
        String getDescriptionDentist = resultSet.getString("DescriptionDentist");
        return new Dentist(getDentistID, getSkills, getDescriptionDentist, getYearsOfExp, getInsurance, getSalary);
    }

    @Override
    protected boolean addDentist(Connection connection, Dentist dentist) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_DENTIST);

                preparedStatement.setString(1, dentist.getDentistID());
                preparedStatement.setInt(2, dentist.getYearsOfExp());
                preparedStatement.setString(3, dentist.getSkill());
                preparedStatement.setDouble(4, dentist.getSalary());
                preparedStatement.setDouble(5, dentist.getInsurance());
                preparedStatement.setString(6, dentist.getDescriptionDentist());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected boolean updateDentist(Connection connection, Dentist dentist) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_DENTIST);
                preparedStatement.setInt(1, dentist.getYearsOfExp());
                preparedStatement.setString(2, dentist.getSkill());
                preparedStatement.setDouble(3, dentist.getSalary());
                preparedStatement.setDouble(4, dentist.getInsurance());
                preparedStatement.setString(5, dentist.getDescriptionDentist());
                preparedStatement.setString(6, dentist.getDentistID());
                preparedStatement.executeUpdate();
                return true;
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }

    @Override
    protected List<Dentist> getDentist(Connection connection, Object object, Object action) throws SQLException {
        ArrayList<Dentist> dentistList = new ArrayList<>();

        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "PagingAccount":
                        preparedStatement = connection.prepareStatement(SQL_GET_PAGING_DENTIST);
                        preparedStatement.setInt(1, ((int) object - 1) * 5);
                        break;
                    case "ShowTop4Dentist":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOP_4_DENTIST);
                        break;
                    case "GetAllDentist":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_DENTIST);
                        break;
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Dentist dentist = getInfoDentistFromSQL(resultSet);
                    dentistList.add(dentist);
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return dentistList;
    }

    @Override
    protected int countDentist(Connection connection) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_TOTAL_DENTIST);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return 0;
    }

    @Override
    protected Dentist getDentistDetail(Connection connection, Object dentistID) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_GET_DENTIST_DETAIL_BY_ID);
                preparedStatement.setString(1, dentistID.toString());
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoDentistFromSQL(resultSet);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

}
