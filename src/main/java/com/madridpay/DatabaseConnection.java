package com.madridpay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set the database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/your_db"; // Replace 'your_db' with your database name
            String username = "root";
            String password = "global@123";

            // Establish the connection
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            // Print stack trace for debugging if the connection fails
            e.printStackTrace();
            return null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Database connection is successful.");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
