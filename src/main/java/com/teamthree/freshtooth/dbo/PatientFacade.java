package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.models.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientFacade extends AbstractPatient<Patient> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_INSERT_PATIENT = "INSERT INTO Patients(PatientID) VALUES(?)";
    private static final String SQL_UPDATE_PATIENT = "UPDATE Patients SET NameParent = ?, PhoneParent = ? WHERE PatientID = ?";

    private Patient getInfoPatientFromSQL(ResultSet resultSet) throws SQLException {
        String getPatientID = resultSet.getString("PatientID");
        String getNameParent = resultSet.getString("NameParent");
        String getPhoneParent = resultSet.getString("PhoneParent");
        return new Patient(getPatientID, getNameParent, getPhoneParent);
    }

    @Override
    protected boolean addPatient(Connection connection, Patient patient) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_PATIENT);

                preparedStatement.setString(1, patient.getPatientID());
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
    protected boolean updatePatient(Connection connection, Patient patient) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_PATIENT);
                preparedStatement.setString(1, patient.getNameParent());
                preparedStatement.setString(2, patient.getPhoneParent());
                preparedStatement.setString(3, patient.getPatientID());
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
    protected Patient getPatient(Connection connection, Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
