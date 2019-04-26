<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<form method="POST" action="LoginServlet">
	<label>
        <span>Mail : </span>
        <input name="mail" type="text" required placeholder="abc@email.com" />
    </label>
    <label>
        <span>Password : </span>
        <input name="password" type="password" required />
    </label>
    <input type="submit" name="login" id="login" value="Login">
</form>
</body>
</html>