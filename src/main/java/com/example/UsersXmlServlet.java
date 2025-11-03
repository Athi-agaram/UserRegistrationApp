package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

@WebServlet("/users-xml")
public class UsersXmlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/xml");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<users>");

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, email FROM users")) {

            while (rs.next()) {
                out.println("  <user>");
                out.println("    <name>" + rs.getString("name") + "</name>");
                out.println("    <email>" + rs.getString("email") + "</email>");
                out.println("  </user>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</users>");
    }
}
