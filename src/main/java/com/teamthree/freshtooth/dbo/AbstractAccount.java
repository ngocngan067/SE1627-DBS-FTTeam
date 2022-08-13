package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractAccount<T> {

    private Connection connection;

    protected abstract String registerAccount(Connection connection, T t, HttpServletRequest request) throws SQLException;

    protected abstract boolean addAccount(Connection connection, T t, Object action) throws SQLException;

    protected abstract boolean updateAccount(Connection connection, T t, Object object) throws SQLException;

    protected abstract List<T> getAccount(Connection connection, Object object, Object action, Object status) throws SQLException;

    protected abstract T checkAccount(Connection connection, Object object, Object action) throws SQLException;

    protected abstract int countAccount(Connection connection, Object status) throws SQLException;

    protected abstract HashMap<Integer, Integer> statisticAccount(Connection connection, Object object) throws SQLException;

    /**
     * *
     * Add a new account
     *
     * @param t
     * @param request
     * @return
     * @throws SQLException
     */
    public String registerAccount(T t, HttpServletRequest request) throws SQLException {
        String tmp = "";

        try {
            connection = DBUtils.makeConnection();
            tmp = registerAccount(connection, t, request);
        } finally {
            connection.close();
        }
        return tmp;
    }

    /**
     * *
     * Add a new account
     *
     * @param t
     * @param action
     * @return
     * @throws SQLException
     */
    public boolean addAccount(T t, Object action) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addAccount(connection, t, action);
        } finally {
            connection.close();
        }
        return check;
    }

    /**
     * *
     * Update Information Account
     *
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

    /**
     * *
     * Paging account in admin page
     *
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

    /**
     * *
     * Check if the account exists
     *
     * @param object
     * @param action
     * @return
     * @throws SQLException
     */
    public T checkAccount(Object object, Object action) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = checkAccount(connection, object, action);
        } finally {
            connection.close();
        }
        return t;
    }

    /**
     * *
     * Count how many accounts in the list
     *
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

    /**
     * *
     * Statistic Account in one month
     *
     * @param object
     * @return
     * @throws SQLException
     */
    public HashMap<Integer, Integer> statisticAccount(Object object) throws SQLException {
        HashMap<Integer, Integer> list = new HashMap<>();

        try {
            connection = DBUtils.makeConnection();
            list = statisticAccount(connection, object);
        } finally {
            connection.close();
        }
        return list;
    }
}
