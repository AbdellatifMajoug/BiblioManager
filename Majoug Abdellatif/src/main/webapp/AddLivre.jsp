<%@page import="com.util.Categorie"%>
<%@page import="com.util.GestionCategorie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter livre</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/bootstrap.js"/></script>
</head>
<body>
 <h2 style="text-align:center;" >Ajouter un livre : </h2>
<br/>
<%
GestionCategorie gc = new GestionCategorie();
List<Categorie> lc = gc.allCategories();
%>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4">
<form action="AddLivre" method="get">
  <div class="mb-3">
    <label for="t" class="form-label">Titre du livre</label>
    <input type="text" name="name" class="form-control" id="t" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Auteur</label>
    <input type="text" name="auteur" class="form-control" id="exampleInputPassword1">
  </div>
    <div class="mb-3">
    <select name ="categorie">
    <option disabled selected value=""> -- selectionner une categorie -- </option>
    <%
    for(Categorie c : lc){
    %>
    <option value=<%=c.getId() %>><%=c.getName() %></option>
    <%} %>
    </select>
  </div>
  <button type="submit" class="btn btn-primary" >Ajouter</button>
</form>
</div>
</div>
</body>
</html>