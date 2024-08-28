package com.healthcaremanagement.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/HealthcareSystemDB?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "LovePapa@2801";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        return conn;
    }
}
