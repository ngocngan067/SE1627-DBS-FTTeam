package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBooking<T> {

    private Connection connection;

    protected abstract boolean addBooking(Connection connection, T booking) throws SQLException;

    protected abstract boolean updateBooking(Connection connection, Object bookingID) throws SQLException;

    protected abstract List<T> getAllBooking(Connection connection, Object object) throws SQLException;

    protected abstract int countBooking(Connection connection) throws SQLException;

    protected abstract T getBooking(Connection connection, Object object) throws SQLException;
    
    /***
     * Add new booking
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
    
    /***
     * Update booking with ID
     * @param bookingID
     * @return
     * @throws SQLException 
     */
    public boolean updateBooking(Object bookingID) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateBooking(connection, bookingID);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Get all booking
     * @param object
     * @return
     * @throws SQLException 
     */
    public List<T> getAllBooking(Object object) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllBooking(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /***
     * Count how many booking in list
     * @return
     * @throws SQLException 
     */
    public int countBooking() throws SQLException {
        int check;
        
        try {
            connection = DBUtils.makeConnection();
            check = countBooking(connection);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Get one booking with id
     * @param object
     * @return
     * @throws SQLException 
     */
    public T getBooking(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getBooking(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
}
