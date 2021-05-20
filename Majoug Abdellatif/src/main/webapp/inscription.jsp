<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/bootstrap.js"/></script>
</head>
<body>
<h2 style="text-align:center;" >Page d'inscription : </h2>
<br/>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4">
<form action="Addetu" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom</label>
    <input type="text" name="nom" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Prenom</label>
    <input type="text" name="prenom" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Login</label>
    <input type="text" name="log" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="pass" class="form-control" id="exampleInputPassword1">
  </div>
<input type="checkbox" onclick="Afficher()"> Afficher le mot de passe
<script>
function Afficher()
{ 
var input = document.getElementById("exampleInputPassword1"); 
if (input.type === "password")
{ 
input.type = "text"; 
} 
else
{ 
input.type = "password"; 
} 
} 
</script>
<br/>
<div style="text-align:center;">
  <button type="submit" class="btn btn-primary" >S'inscrire</button>
</div>
</form>
</div>
</div>
</body>
</html>