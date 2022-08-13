package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBooking<T> {

    private Connection connection;

    protected abstract boolean addBooking(Connection connection, T booking) throws SQLException;

    protected abstract boolean updateBooking(Connection connection, T booking, Object action) throws SQLException;

    protected abstract T getBooking(Connection connection, Object object, Object action) throws SQLException;

    protected abstract List<T> getAllBooking(Connection connection, T booking, Object action, Object value) throws SQLException;

    protected abstract int countBooking(Connection connection, Object status, Object action, Object userID) throws SQLException;

    /**
     * *
     * Add new booking
     *
     * @param booking
     * @return
     * @throws SQLException
     */
    public boolean addBooking(T booking) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addBooking(connection, booking);
        } finally {
            connection.close();
        }

        return check;
    }

    /**
     * *
     * Update booking with ID
     *
     * @param booking
     * @param action
     * @return
     * @throws SQLException
     */
    public boolean updateBooking(T booking, Object action) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateBooking(connection, booking, action);
        } finally {
            connection.close();
        }

        return check;
    }

    /**
     * *
     * Check if the account exists
     *
     * @param object
     * @param action
     * @return
     * @throws SQLException
     */
    public T getBooking(Object object, Object action) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getBooking(connection, object, action);
        } finally {
            connection.close();
        }
        return t;
    }

    /**
     * *
     * Get all booking
     *
     * @param booking
     * @param action
     * @param value
     * @return
     * @throws SQLException
     */
    public List<T> getAllBooking(T booking, Object action, Object value) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllBooking(connection, booking, action, value);
        } finally {
            connection.close();
        }
        return list;
    }

    /**
     * *
     * Count how many booking in list
     *
     * @param status
     * @param action
     * @param userID
     * @return
     * @throws SQLException
     */
    public int countBooking(Object status, Object action, Object userID) throws SQLException {
        int check;

        try {
            connection = DBUtils.makeConnection();
            check = countBooking(connection, status, action, userID);
        } finally {
            connection.close();
        }

        return check;
    }
}
