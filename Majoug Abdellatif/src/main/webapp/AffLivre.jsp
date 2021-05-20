<%@page import="com.util.Livre"%>
<%@page import="com.util.GestionLivre"%>
<%@page import="com.util.Categorie"%>
<%@page import="com.util.GestionCategorie"%>
<%@page import="com.util.Etudiant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des livres</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
GestionCategorie gc = new GestionCategorie();
List<Categorie> lc = gc.allCategories();
List<Livre> lv = new ArrayList<Livre>();
if(request.getParameter("cat") != null){
	GestionLivre gl = new GestionLivre();
	lv = gl.findLivreByCategorie(request.getParameter("cat"));
}

%>
<div class="container">
  <h2 style="text-align:center;" >Liste des livres par catégorie : </h2>
  <br/>
  <form action="">
  Choisir la categorie du livre:
  <select name = "cat" >
  <option disabled selected value=""> -- selectionner une categorie -- </option>
  <%
  for(Categorie c : lc){
  %>
  <option value =<%= c.getName() %> ><%= c.getName() %> </option>
  <%} %>
  </select>
  <input type = submit value = "chercher livre">  
  </form>    
<hr/>
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>Titre</th>
        <th>Auteur</th>
        <th>Categorie</th>
      </tr>
    </thead>
      <%
		  if(request.getParameter("cat") != null) {   
			  for(Livre l : lv){
 	 %> 
    <tbody>
 	
      <tr>
        <td><%=l.getName() %></td>
        <td><%=l.getAuteur() %></td>
        <td><%= gc.findCategorieById(l.getCategorie()).getName()  %></td>
      </tr>
 
    </tbody>
    <%}} %>
  </table>
</div>
<div style="text-align:center;">
<form action="AddLivre.jsp" method="get">  
  <input type="submit" class="btn btn-primary" value="Ajouter un livre">
</form>
</div>
</body>
</html>