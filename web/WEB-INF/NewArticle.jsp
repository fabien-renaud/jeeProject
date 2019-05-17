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
<form method="POST" action="new-article">
	<label>
        <span>Titre : </span>
        <input name="title" type="text" required placeholder="Mon super article" />
    </label>
    <label>
        <span>Contenu : </span>
        <input name="description" type="text" required />
    </label>
    <input type="submit" name="NewArticle" id="NewArticle" value="Créer mon article !">
</form>
<a href="./home">Retour à la liste des articles</a>
</div>
</body>
</html>