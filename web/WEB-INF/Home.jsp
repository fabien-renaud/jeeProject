<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
    <meta charset="UTF-8">
    <title>My JSP Page</title>
</head>
<body>
<div class="container">
	<% out.println("Coucou");
	out.println(session.getAttribute("mail"));%>
	<br/>
    <button onclick="location.href='SignOut'" class="signOutButton">Sign out</button>
</div>
</body>
</html>