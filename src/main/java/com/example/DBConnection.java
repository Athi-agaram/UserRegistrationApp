package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=userdb;encrypt=false",
                    "sa", 
                    "admin@123" 
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
