package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.models.Booking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookingFacade extends AbstractBooking<Booking> {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String SQL_GET_BOOKING_WITH_SERVICE = "SELECT * FROM Booking WHERE ServiceID = ? AND BookingDate = ? AND BookingStatus = ?";
//    private static final String SQL_GET_TOP_5_BOOKING_WITH_USERID = "SELECT TOP 5 * FROM Booking WHERE PatientID = ?";
    private static final String SQL_GET_TOP_5_BOOKING_WITH_USERID = "SELECT * FROM Booking WHERE PatientID = ? LIMIT 5;";
//    private static final String SQL_GET_TOP_5_BOOKING_WITH_STATUS = "SELECT TOP 5 * FROM Booking WHERE PatientID = ? AND BookingStatus = ?";
    private static final String SQL_GET_TOP_5_BOOKING_WITH_STATUS = "SELECT * FROM Booking WHERE PatientID = ? AND BookingStatus = ? LIMIT 5;";
//    private static final String SQL_GET_NEXT_BOOKING_WITH_USERID = "SELECT * FROM Booking WHERE PatientID = ? ORDER BY BookingID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_NEXT_BOOKING_WITH_USERID = "SELECT * FROM Booking WHERE PatientID = ? ORDER BY BookingID LIMIT 5 OFFSET ?;";
//    private static final String SQL_GET_NEXT_BOOKING_WITH_STATUS = "SELECT * FROM Booking WHERE PatientID = ? AND BookingStatus = ? ORDER BY BookingID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_NEXT_BOOKING_WITH_STATUS = "SELECT * FROM Booking WHERE PatientID = ? AND BookingStatus = ? ORDER BY BookingID LIMIT 5 OFFSET ?;";
    private static final String SQL_INSERT_BOOKING = "INSERT INTO Booking(BookingID, ServiceID, PatientID, BookingDate, SlotID) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_GET_TOTAL_BOOKING = "SELECT COUNT(*) FROM Booking";
    private static final String SQL_GET_ALL_BOOKING_WITH_ID = "SELECT COUNT(*) FROM Booking WHERE PatientID = ?";
    private static final String SQL_GET_TOTAL_BOOKING_WITH_STATUS = "SELECT COUNT(*) FROM Booking WHERE BookingStatus = ? AND PatientID = ?";
    private static final String SQL_UPDATE_STATUS_BOOKING = "UPDATE Booking SET BookingStatus = ? WHERE BookingID = ? AND PatientID = ?";
    private static final String SQL_UPDATE_STATUS_BOOKING_IN_DENTIST = "UPDATE Booking SET BookingStatus = ?, DentistID = ? WHERE BookingID = ?";
    private static final String SQL_UPDATE_STATUS_BOOKING_IN_DENTIST_NO_DENTIST = "UPDATE Booking SET BookingStatus = ? WHERE BookingID = ?";
//    private static final String SQL_GET_PAGING_BOOKING = "SELECT * FROM Booking ORDER BY BookingID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY;";
    private static final String SQL_GET_PAGING_BOOKING = "SELECT * FROM Booking ORDER BY BookingID LIMIT 5 OFFSET ?;";
//    private static final String SQL_GET_TOP_5_PAGING_BOOKING = "SELECT TOP 5 * FROM Booking";
    private static final String SQL_GET_TOP_5_PAGING_BOOKING = "SELECT * FROM Booking";
    private static final String SQL_GET_ALL_BOOKING = "SELECT * FROM Booking WHERE BookingStatus = 1";
    private static final String SQL_GET_BOOKING_ID = "SELECT * FROM Booking WHERE BookingID = ?";
    private static final String SQL_GET_BOOKING_PATIENT = "SELECT * FROM Booking WHERE PatientID = ?";

    private Booking getInfoBookingFromSQL(ResultSet resultSet) throws SQLException {
        String getBookingID = resultSet.getString("BookingID");
        String getServiceID = resultSet.getString("ServiceID");
        String getPatientID = resultSet.getString("PatientID");
        int getBookingStatus = resultSet.getInt("BookingStatus");
        Date getBookingDate = resultSet.getDate("BookingDate");
        String getBookingNote = resultSet.getString("BookingNote");
        String getDentistID = resultSet.getString("DentistID");
        String getSlotID = resultSet.getString("SlotID");
        Timestamp getBookingCreated = resultSet.getTimestamp("BookingCreated");

        return new Booking(getBookingID, getServiceID, getPatientID, getBookingNote, getDentistID, getSlotID, getBookingStatus, getBookingDate, getBookingCreated);
    }

    @Override
    protected boolean addBooking(Connection connection, Booking booking) throws SQLException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_INSERT_BOOKING);

                preparedStatement.setString(1, booking.getBookingID());
                preparedStatement.setString(2, booking.getServiceID());
                preparedStatement.setString(3, booking.getPatientID());
                preparedStatement.setDate(4, booking.getBookingDate());
                preparedStatement.setString(5, booking.getSlotID());
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
    protected boolean updateBooking(Connection connection, Booking booking, Object action) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "UpdateStatusInUser":
                        preparedStatement = connection.prepareStatement(SQL_UPDATE_STATUS_BOOKING);
                        preparedStatement.setInt(1, booking.getBookingStatus());
                        preparedStatement.setString(2, booking.getBookingID());
                        preparedStatement.setString(3, booking.getPatientID());
                        break;
                    case "UpdateStatusInDentist":
                        preparedStatement = connection.prepareStatement(SQL_UPDATE_STATUS_BOOKING_IN_DENTIST);
                        preparedStatement.setInt(1, booking.getBookingStatus());
                        preparedStatement.setString(2, booking.getDentistID());
                        preparedStatement.setString(3, booking.getBookingID());
                        break;
                    case "UpdateStatusInDentistNoDentist":
                        preparedStatement = connection.prepareStatement(SQL_UPDATE_STATUS_BOOKING_IN_DENTIST_NO_DENTIST);
                        preparedStatement.setInt(1, booking.getBookingStatus());
                        preparedStatement.setString(2, booking.getBookingID());
                        break;
                }

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
    protected List<Booking> getAllBooking(Connection connection, Booking booking, Object action, Object value) throws SQLException {
        ArrayList<Booking> bookingList = new ArrayList<>();

        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "GetBookingWithService":
                        preparedStatement = connection.prepareStatement(SQL_GET_BOOKING_WITH_SERVICE);
                        preparedStatement.setString(1, booking.getServiceID());
                        preparedStatement.setDate(2, booking.getBookingDate());
                        preparedStatement.setInt(3, booking.getBookingStatus());
                        break;
                    case "GetTop5BookingWithUserId":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOP_5_BOOKING_WITH_USERID);
                        preparedStatement.setString(1, booking.getPatientID());
                        break;
                    case "GetTop5BookingWithStatus":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOP_5_BOOKING_WITH_STATUS);
                        preparedStatement.setString(1, booking.getPatientID());
                        preparedStatement.setInt(2, booking.getBookingStatus());
                        break;
                    case "GetNext5BookingWithUserId":
                        preparedStatement = connection.prepareStatement(SQL_GET_NEXT_BOOKING_WITH_USERID);
                        preparedStatement.setString(1, booking.getPatientID());
                        preparedStatement.setInt(2, (Integer.parseInt(value.toString())));
                        break;
                    case "GetNext5BookingWithStatus":
                        preparedStatement = connection.prepareStatement(SQL_GET_NEXT_BOOKING_WITH_STATUS);
                        preparedStatement.setString(1, booking.getPatientID());
                        preparedStatement.setInt(2, booking.getBookingStatus());
                        preparedStatement.setInt(3, (Integer.parseInt(value.toString())));
                        break;
                    case "GetPagingBooking":
                        preparedStatement = connection.prepareStatement(SQL_GET_PAGING_BOOKING);
                        preparedStatement.setInt(1, Integer.parseInt(value.toString()));
                        break;
                    case "GetTop5PagingBooking":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOP_5_PAGING_BOOKING);
                        break;
                    case "GetAllBooking":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_BOOKING);
                        break;
                }

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Booking getBooking = getInfoBookingFromSQL(resultSet);
                    bookingList.add(getBooking);
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
        return bookingList;
    }

    @Override
    protected int countBooking(Connection connection, Object status, Object action, Object userID) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "GetTotalBooking":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOTAL_BOOKING);
                        break;
                    case "GetTotalBookingWithStatus":
                        preparedStatement = connection.prepareStatement(SQL_GET_TOTAL_BOOKING_WITH_STATUS);
                        preparedStatement.setInt(1, (Integer.parseInt(status.toString())));
                        preparedStatement.setString(2, userID.toString());
                        break;
                    case "GetAllBookingWithID":
                        preparedStatement = connection.prepareStatement(SQL_GET_ALL_BOOKING_WITH_ID);
                        preparedStatement.setString(1, userID.toString());
                        break;
                }

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
    protected Booking getBooking(Connection connection, Object object, Object action) throws SQLException {
        try {
            if (connection != null) {
                switch (action.toString()) {
                    case "GetBookingID":
                        preparedStatement = connection.prepareStatement(SQL_GET_BOOKING_ID);
                        preparedStatement.setString(1, object.toString());
                        break;
                    case "GetBookingWithPatient":
                        preparedStatement = connection.prepareStatement(SQL_GET_BOOKING_PATIENT);
                        preparedStatement.setString(1, object.toString());
                        break;
                }

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return getInfoBookingFromSQL(resultSet);
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
