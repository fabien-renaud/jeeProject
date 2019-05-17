<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
    <meta charset="ISO-8859-1">
    <title>Sign Up</title>
</head>
<body>
<div class="container">
<form method="POST" action="signup">
	<label>
        <span>Mail : </span>
        <input name="mail" type="text" required placeholder="abc@email.com" />
    </label>
    <label>
        <span>Nom : </span>
        <input name="nom" type="text" required />
    </label>
    <label>
        <span>Password : </span>
        <input name="password" type="password" required />
    </label>
    <input type="submit" name="SignUp" id="SignUp" value="SignUp">
</form>
</div>
</body>
</html>