<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My JSP Page</title>
</head>
<body>
	<% out.println("Coucou");
	out.println(session.getAttribute("mail"));%>
	<br/>
	<a href="SignOut">Sign out</a>
</body>
</html>