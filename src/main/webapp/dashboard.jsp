<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<%
    if (session == null || session.getAttribute("userEmail") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dash board</title>
</head>
<body>
    <h2>Welcome, <%= session.getAttribute("userEmail") %>!</h2>
    <p>You are successfully logged in.</p>
    <a href="logout">Logout</a>
</body>
</html>
