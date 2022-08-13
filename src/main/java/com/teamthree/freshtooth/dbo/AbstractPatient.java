package com.teamthree.freshtooth.dbo;

import com.teamthree.freshtooth.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractPatient<T> {

    private Connection connection;

    protected abstract boolean addPatient(Connection connection, T patient) throws SQLException;

    protected abstract boolean updatePatient(Connection connection, T patient) throws SQLException;

    protected abstract T getPatient(Connection connection, Object object) throws SQLException;
    
    /***
     * Add information patient
     * @param patient
     * @return
     * @throws SQLException 
     */
    public boolean addPatient(T patient) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = addPatient(connection, patient);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Update information patient
     * @param patient
     * @return
     * @throws SQLException 
     */
    public boolean updatePatient(T patient) throws SQLException {
        boolean check;
        
        try {
            connection = DBUtils.makeConnection();
            check = updatePatient(connection, patient);
        } finally {
            connection.close();
        }
        
        return check;
    }
    
    /***
     * Get information patient
     * @param object
     * @return
     * @throws SQLException 
     */
    public T getPatient(Object object) throws SQLException {
        T t = null;

        try {
            connection = DBUtils.makeConnection();
            t = getPatient(connection, object);
        } finally {
            connection.close();
        }
        return t;
    }
}
