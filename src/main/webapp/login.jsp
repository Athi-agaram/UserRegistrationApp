<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        form {
            background-color: #f9f9f9;
            padding: 20px;
            width: 300px;
            border-radius: 8px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin: 6px 0;
        }
        input[type="submit"] {
            background-color: #1976d2;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            cursor: pointer;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        Email: <input type="text" name="email"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>

    <p class="error">
        <% 
            String error = request.getParameter("error");
            if ("invalid".equals(error)) {
                out.print("Invalid email or password!");
            }
        %>
    </p>
</body>
</html>
