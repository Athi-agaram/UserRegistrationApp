<%@ page import="java.sql.*" %>
<%@ page import="jakarta.servlet.*, jakarta.servlet.http.*" %>
<html>
<head>
    <title>Registered Users</title>
</head>
<body>
    <h2>List of Registered Users</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <%
            // Database connection details
            String url = "jdbc:sqlserver://localhost:1433;databaseName=UserDB;encrypt=false";
            String username = "sa"; // change to your username
            String password = "admin@123"; // change to your password

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name, email FROM Users");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("</tr>");
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                e.printStackTrace(new java.io.PrintWriter(out));
            }

        %>
    </table>
</body>
</html>
