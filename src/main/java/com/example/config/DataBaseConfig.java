package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    private static final String url="jdbc:postgresql://localhost:5432/hotel_booking";
    private static final  String username="postgres";
    private static final String password="Dlbarmirze5678.";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
