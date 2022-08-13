package com.teamthree.freshtooth.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBUtils {

    public static Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//            String urlDataConnection = "jdbc:sqlserver://localhost;databaseName=FreshTooth";
//            String urlDataConnection = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6509242";
            String urlDataConnection = "jdbc:mysql://bt1wmj6ue4try15izexg-mysql.services.clever-cloud.com:3306/bt1wmj6ue4try15izexg";
//            String urlDataConnection = "jdbc:mysql://localhost:3306/FreshTooth";

//            Connection dataConn = DriverManager.getConnection(urlDataConnection, "sa", Encrypt.decrypt("nRTXd5P75WfODslaS0/TfA==", "ssshhhhhhhhhhh!!!!"));
//            Connection dataConn = DriverManager.getConnection(urlDataConnection, "sql6509242", "riMU1bjIT9");
            Connection dataConn = DriverManager.getConnection(urlDataConnection, "unc6jnqoimdkfsri", "PnQHWYK44jT1nk8oBEQl");
//            Connection dataConn = DriverManager.getConnection(urlDataConnection, "root", Encrypt.decrypt("Iu2IBJxRTjs8GUW2gcG+1w==", "ssshhhhhhhhhhh!!!!"));

            return dataConn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
