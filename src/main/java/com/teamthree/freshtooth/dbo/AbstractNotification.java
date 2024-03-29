package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNotification<T> {
    
    private Connection connection;
    
    protected abstract List<T> getAllNotification(Connection connection, Object object) throws SQLException;
    
    protected abstract boolean addNotification(Connection connection, T notification) throws SQLException;
    
    protected abstract boolean updateNotification(Connection connection, Object userID) throws SQLException;
    
    protected abstract int countNotification(Connection connection, Object userID) throws SQLException;
    
    /***
     * Get all notification in one user
     * @param object
     * @return
     * @throws SQLException 
     */
    public List<T> getAllNotification(Object object) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllNotification(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /***
     * Add notification
     * @param notification
     * @return
     * @throws SQLException 
     */
    public boolean addNotification(T notification) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = addNotification(connection, notification);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Update notification
     * @param userID
     * @return
     * @throws SQLException 
     */
    public boolean updateNotification(Object userID) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateNotification(connection, userID);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Count how many notification in one user
     * @param userID
     * @return
     * @throws SQLException 
     */
    public int countNotification(Object userID) throws SQLException {
        int check;
        
        try {
            connection = DBUtils.makeConnection();
            check = countNotification(connection, userID);
        } finally {
            connection.close();
        }
        
        return check;
    }
}
