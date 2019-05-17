<%@page import="fr.epsi.jeeProject.dao.HSQLImpl.BlogDao"%>
<%@page import="fr.epsi.jeeProject.beans.Blog"%>
<%@page import="java.util.List"%>
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
	<%
	BlogDao monBlogDao = new BlogDao();
	List<Blog> monBlog = monBlogDao.getAllBlogs();
	out.println("<br><div class=\"blocWhite\"><h1>"+monBlog.get(1).getTitre()+"</h1><h3>"+monBlog.get(1).getDescription()+"</h3></div>");
	%>
	<button onclick="location.href='SignOut'" class="signOutButton">Sign out</button>
</div>
</body>
</html>