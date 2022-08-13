package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSlot<T> {

    private Connection connection;

    protected abstract List<T> getAllSlot(Connection connection) throws SQLException;
    
    protected abstract T getSlot(Connection connection, Object slotID) throws SQLException;
    
    /***
     * Get all slot
     * @return
     * @throws SQLException 
     */
    public List<T> getAllSlot() throws SQLException {
        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getAllSlot(connection);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /**
     * *
     * Get slot
     *
     * @param slotID
     * @return
     * @throws SQLException
     */
    public T getSlot(Object slotID) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getSlot(connection, slotID);
        } finally {
            connection.close();
        }
        return t;
    }
}
