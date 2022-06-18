package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFeedBack<T> {

    private Connection connection;

    protected abstract boolean addFeedBack(Connection connection, T feedBack) throws SQLException;

    protected abstract boolean updateFeedBack(Connection connection, Object feedBackID) throws SQLException;

    protected abstract List<T> getAllFeedBack(Connection connection, Object object) throws SQLException;
    
    protected abstract int countFeedBack(Connection connection) throws SQLException;
    
    /***
     * Add a new feedBack
     * @param feedBack
     * @return
     * @throws SQLException 
     */
    public boolean addFeedBack(T feedBack) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = addFeedBack(connection, feedBack);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Update feedBack with id
     * @param feedBackID
     * @return
     * @throws SQLException 
     */
    public boolean updateFeedBack(Object feedBackID) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateFeedBack(connection, feedBackID);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Get all feedBack
     * @param object
     * @return
     * @throws SQLException 
     */
    public List<T> getAllFeedBack(Object object) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllFeedBack(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /***
     * Count how many feedBack in the list
     * @return
     * @throws SQLException 
     */
    public int countFeedBack() throws SQLException {
        int check;
        
        try {
            connection = DBUtils.makeConnection();
            check = countFeedBack(connection);
        } finally {
            connection.close();
        }
        
        return check;
    }
}
