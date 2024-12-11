package com.madridpay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public boolean addUser(String name, String email) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getAllUsers() {
        String query = "SELECT * FROM users";
        StringBuilder users = new StringBuilder();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                users.append("ID: ").append(resultSet.getInt("id"))
                     .append(", Name: ").append(resultSet.getString("name"))
                     .append(", Email: ").append(resultSet.getString("email")).append("<br>");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users.toString();
    }
}
