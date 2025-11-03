package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/users-json")
public class UsersJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONArray usersArray = new JSONArray();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, email FROM users")) {

            while (rs.next()) {
                JSONObject user = new JSONObject();
                user.put("name", rs.getString("name"));
                user.put("email", rs.getString("email"));
                usersArray.put(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject result = new JSONObject();
        result.put("users", usersArray);

        response.getWriter().write(result.toString());
    }
}
