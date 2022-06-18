package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDentist<T> {

    private Connection connection;

    protected abstract boolean addDentist(Connection connection, T t) throws SQLException;

    protected abstract boolean updateDentist(Connection connection, T dentist) throws SQLException;

    protected abstract List<T> getDentist(Connection connection, Object object, Object action) throws SQLException;

    protected abstract int countDentist(Connection connection) throws SQLException;
    
    /***
     * Add a new Dentist
     * @param dentist
     * @return
     * @throws SQLException 
     */
    public boolean addDentist(T dentist) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = addDentist(connection, dentist);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Update Dentist with id
     * @param dentist
     * @return
     * @throws SQLException 
     */
    public boolean updateDentist(T dentist) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updateDentist(connection, dentist);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Get all Dentist
     * @param object
     * @param action
     * @return
     * @throws SQLException 
     */
    public List<T> getDentist(Object object, Object action) throws SQLException {

        List<T> list = new ArrayList<>();

        try {
            connection = DBUtils.makeConnection();
            list = getDentist(connection, object, action);
        } finally {
            connection.close();
        }
        return list;
    }
    
    /***
     * Count how many dentist in the list
     * @return
     * @throws SQLException 
     */
    public int countDentist() throws SQLException {
        int check;
        
        try {
            connection = DBUtils.makeConnection();
            check = countDentist(connection);
        } finally {
            connection.close();
        }
        
        return check;
    }
}
