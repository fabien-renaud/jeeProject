<%@page import="fr.epsi.jeeProject.dao.HSQLImpl.BlogDao"%>
<%@page import="fr.epsi.jeeProject.beans.Blog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="UTF-8">
<title>My JSP Page</title>
</head>
<body>
	<div class="container">
		<div>
			<% out.println("<p style=\"display: inline-block\">Bienvenue " + session.getAttribute("mail") + "</p>"); %>
			<a href="./signout" class="float-right">Sign out ></a>
		</div>
		<h2>Liste des articles</h2>
		<%
		List<Blog> mesBlog = (List<Blog>) request.getAttribute("mesBlog");
		for(Blog monBlog : mesBlog) {
			out.println("<a href=\"./article?id=" + monBlog.getId() + "\"><div class=\"blocWhite\">");
			out.println("<h3>" + monBlog.getTitre() + "</h3>");
			out.println("<p>" + monBlog.getCreateur().getEmail() + " - " + monBlog.getDateCreation() + "</p>");
			out.println("<p>" + monBlog.getDescription() + "...</p>");
			out.println("</br></br><button class=\"buttonVoirArticle\">Pour voir l'article complet, cliquez ici !</button></div></a>");
		}
		%>
		<br/>
		<a href="./new-article" style="padding-bottom: 30px;">Créer un nouvel article</a>
	</div>
</body>
</html>