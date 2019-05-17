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
			<a href="./signout" class="signOut">Sign out ></a>
		</div>
		<%
		Blog monBlog = (Blog) request.getAttribute("monBlog");
		if(monBlog != null) {
			out.println("<h3>" + monBlog.getTitre() + "</h3><p>"
					+ monBlog.getCreateur().getEmail() + " - " + monBlog.getDateCreation() + "</p><p>"
					+ monBlog.getDescription() + "</p>");
			
		} else {
			%><h3>Oups ! Notre bibliothécaire n'a pas trouvé l'article que vous cherchiez...</h3><%
		}
		%>
		
		<a href="./home">Retour à la liste des articles</a>
		<% out.println("<a href=\"./delete-article?id=" + monBlog.getId() + "\" class=\"float-right\">Supprimer l'article</a>"); %>
	</div>
</body>
</html>