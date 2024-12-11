package com.madridpay;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        boolean isAdded = userService.addUser(name, email);
        response.getWriter().write(isAdded ? "User added successfully!" : "Failed to add user.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String users = userService.getAllUsers();
        response.setContentType("text/html");
        response.getWriter().write(users);
    }
}
