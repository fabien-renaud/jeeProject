<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<form>
	<label>
        <span>Mail : </span>
        <input name="mail" type="text" required value="abc@email.com" />
    </label>
    <label>
        <span>Password : </span>
        <input name="password" type="password" required />
    </label>
    <input type="button" name="login" id="login" value="Login">
    <input type="button" name="reset" id="reset" value="reset">
</form>
</body>
</html>