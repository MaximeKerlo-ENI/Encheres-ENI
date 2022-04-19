<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Nouveau profil" />
</jsp:include>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<a href="./"><img title="Retour à l'accueil"  src="./img/logo_ENI.jpg" width="50" height="50"></a>
			<strong>ENI-Encheres</strong>
		</div>
	</div>
	
	<h1 class="text-center">Nouveau profil</h1>
	
	<form action="./ServletNewProfile" method="post">
		<div class="row">
			<div class="container text-center">
				<label class="mt-3">Pseudo : </label>
				<input type="text" name="pseudo">		
				<label class="ms-3">Nom : </label>
				<input type="text" name="nom">
			</div>
		</div><br>
		<div class="row">
			<div class="container text-center">
				<label>Prénom : </label>
				<input type="text" name="prenom">		
				<label class="ms-3">Email : </label>
				<input type="text" name="mail">
			</div>
		</div><br>
		<div class="row">
			<div class="container text-center">
				<label>Téléphone : </label>
				<input type="text" name="tel">		
				<label class="ms-3">Rue : </label>
				<input type="text" name="rue">
			</div>
		</div><br>
		<div class="row">
			<div class="container text-center">
				<label>Code postal : </label>
				<input type="text" name="cpo">		
				<label class="ms-3">Ville : </label>
				<input type="text" name="ville">
			</div>
		</div><br>
		<div class="row">
			<div class="container text-center">
				<label>Mot de passe: </label>
				<input type="password" name="pwd">		
				<label class="ms-3">Confirmation: </label>
				<input type="password" name="confirm">
			</div>
		</div><br>
		<div class="row">
			<div class="container text-center">
				<button class="btn btn-lg btn-primary" type="submit">Créer</button>
				<a href="./" class="btn btn-lg btn-primary">Annuler</a>
			</div>
		</div>
	</form>
</body>
</html>