package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount<T> {
    
    private Connection connection;
    
    protected abstract boolean registerAccount(Connection connection, T t) throws SQLException;
    
    protected abstract boolean updateAccount(Connection connection, T t, Object object) throws SQLException;

    protected abstract List<T> getAccount(Connection connection, Object object, Object action, Object status) throws SQLException;

    protected abstract T checkAccount(Connection connection, Object object) throws SQLException;

    protected abstract int countAccount(Connection connection, Object status) throws SQLException;
    
    protected abstract List<Integer> statisticAccount(Connection connection, Object object) throws SQLException;
    
    /***
     * Add a new account
     * @param t
     * @return
     * @throws SQLException 
     */
    public boolean registerAccount(T t) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = registerAccount(connection, t);
        } finally {
            connection.close();
        }
        return check;
    }
    
    /***
     * Update Information Account
     * @param t
     * @param object
     * @return
     * @throws SQLException 
     */
    public boolean updateAccount(T t, Object object) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateAccount(connection, t, object);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Paging account in admin page
     * @param object
     * @param action
     * @param status
     * @return
     * @throws SQLException 
     */
    public List<T> getAccount(Object object, Object action, Object status) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAccount(connection, object, action, status);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /***
     * Check if the account exists
     * @param object
     * @return
     * @throws SQLException 
     */
    public T checkAccount(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = checkAccount(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
    
    /***
     * Count how many accounts in the list
     * @param status
     * @return
     * @throws SQLException 
     */
    public int countAccount(Object status) throws SQLException {
        int check;
        
        try {
            connection = DBUtils.makeConnection();
            check = countAccount(connection, status);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Statistic Account in one month
     * @param object
     * @return
     * @throws SQLException 
     */
    public List<Integer> statisticAccount(Object object) throws SQLException {
        List<Integer> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = statisticAccount(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }
}
