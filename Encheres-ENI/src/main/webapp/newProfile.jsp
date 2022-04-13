<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Nouveau profil" />
</jsp:include>
<title>Nouveau profile</title>
</head>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<h3>ENI-Encheres</h3>
		</div>
	</div>
	
	<h1 class="text-center">Nouveau profil</h1>
	
	<div class="row">
		<div class="container text-center">
			<label>Identifiant : </label>
			<input type="text">		
			<label class="ms-3">Nom : </label>
			<input type="text">
		</div>
	</div><br>
	<div class="row">
		<div class="container text-center">
			<label>Prénom : </label>
			<input type="text">		
			<label class="ms-3">Email : </label>
			<input type="text">
		</div>
	</div><br>
	<div class="row">
		<div class="container text-center">
			<label>Téléphone : </label>
			<input type="text">		
			<label class="ms-3">Rue : </label>
			<input type="text">
		</div>
	</div><br>
	<div class="row">
		<div class="container text-center">
			<label>Code postal : </label>
			<input type="text">		
			<label class="ms-3">Ville : </label>
			<input type="text">
		</div>
	</div><br>
	<div class="row">
		<div class="container text-center">
			<label>Mot de passe: </label>
			<input type="password">		
			<label class="ms-3">Confirmation : </label>
			<input type="password">
		</div>
	</div><br>
	<div class="row">
		<div class="container text-center">
			<form action="">
			<button class="btn btn-lg btn-primary">Créer</button>
			<a href="./index.jsp" class="btn btn-lg btn-primary">Annuler</a>
			</form>
		</div>
	</div>
</body>
</html>