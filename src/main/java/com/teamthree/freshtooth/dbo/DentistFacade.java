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
    private static final String SQL_INSERT_DENTIST = "INSERT INTO Dentists(DentistID, YearsOfExp, Skills, Salary, Insurance) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DENTIST = "UPDATE Dentists SET YearsOfExp = ?, Skills = ?, Salary = ?, Insurance = ? WHERE DentistID = ?";
    private static final String SQL_GET_PAGING_DENTIST = "SELECT * FROM Dentists ORDER BY DentistID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";

    private Dentist getInfoNotificationFromSQL(ResultSet resultSet) throws SQLException {
        String getDentistID = resultSet.getString("DentistID");
        int getYearsOfExp = resultSet.getInt("YearsOfExp");
        String getSkills = resultSet.getString("Skills");
        int getSalary = resultSet.getInt("Salary");
        int getInsurance = resultSet.getInt("Insurance");
        return new Dentist(getDentistID, getSkills, getYearsOfExp, getSalary, getInsurance);
    }

    @Override
    protected boolean addDentist(Connection connection, Dentist dentist) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_DENTIST);

                preparedStatement.setString(1, dentist.getDentistID());
                preparedStatement.setInt(2, dentist.getYearsOfExp());
                preparedStatement.setString(3, dentist.getSkill());
                preparedStatement.setInt(4, dentist.getSalary());
                preparedStatement.setInt(5, dentist.getInsurance());
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
                preparedStatement.setInt(3, dentist.getSalary());
                preparedStatement.setInt(4, dentist.getInsurance());
                preparedStatement.setString(5, dentist.getDentistID());
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
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Dentist dentist = getInfoNotificationFromSQL(resultSet);
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

}
