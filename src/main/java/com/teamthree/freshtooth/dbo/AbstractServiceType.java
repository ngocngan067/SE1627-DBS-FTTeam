package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceType<T> {

    private Connection connection;

    protected abstract List<T> getAllServiceType(Connection connection, Object object, Object action) throws SQLException;

    protected abstract T getServiceType(Connection connection, Object serviceTypeID) throws SQLException;

    protected abstract boolean addServiceType(Connection connection, T serviceType) throws SQLException;

    protected abstract boolean updateServiceType(Connection connection, T serviceType, Object action) throws SQLException;

    protected abstract int countServiceType(Connection connection) throws SQLException;

    /**
     * *
     * Get all service type
     *
     * @param object
     * @param action
     * @return
     * @throws SQLException
     */
    public List<T> getAllServiceType(Object object, Object action) throws SQLException {
        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllServiceType(connection, object, action);
        } finally {
            connection.close();
        }
        return list;
    }

    /**
     * Get Service Type
     *
     * @param serviceTypeID
     * @return
     * @throws SQLException
     */
    public T getServiceType(Object serviceTypeID) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getServiceType(connection, serviceTypeID);
        } finally {
            connection.close();
        }
        return t;
    }

    /**
     * Add Service Type
     *
     * @param serviceType
     * @return
     * @throws SQLException
     */
    public boolean addServiceType(T serviceType) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = addServiceType(connection, serviceType);
        } finally {
            connection.close();
        }

        return check;
    }

    /**
     * Update service type
     *
     * @param serviceType
     * @param action
     * @return
     * @throws SQLException
     */
    public boolean updateServiceType(T serviceType, Object action) throws SQLException {
        boolean check;

        try {
            connection = DBUtils.makeConnection();
            check = updateServiceType(connection, serviceType, action);
        } finally {
            connection.close();
        }

        return check;
    }

    /**
     * *
     * Count how many service type in the list
     *
     * @return
     * @throws SQLException
     */
    public int countServiceType() throws SQLException {
        int check;

        try {
            connection = DBUtils.makeConnection();
            check = countServiceType(connection);
        } finally {
            connection.close();
        }

        return check;
    }
}
