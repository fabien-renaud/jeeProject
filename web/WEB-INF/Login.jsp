<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<div class="container">
<form method="POST" action="Login">
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
</div>
</body>
</html>