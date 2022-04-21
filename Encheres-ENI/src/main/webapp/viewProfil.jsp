<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Profil" />
</jsp:include>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<a href="./"><img title="Retour à l'accueil" alt=""
				src="./img/logo_ENI.png" width="50" height="50"></a> <strong>ENI-Encheres</strong>
		</div>
		<div class="col-5 text-end">
			<%@ include file="./WEB-INF/include/connection-status.jsp"%>
		</div>
	</div>

	<div class="container text-center">
		<!-- pseudo -->
		<label>Pseudo : </label> <label>${utilisateurConnecte.pseudo}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- nom -->
		<label>Nom : </label> <label>${utilisateurConnecte.nom}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- prenom -->
		<label>Prénom : </label> <label>${utilisateurConnecte.prenom}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- mail -->
		<label>Mail : </label> <label>${utilisateurConnecte.email}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- tel -->
		<label>Téléphone : </label> <label>${utilisateurConnecte.telephone}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- rue -->
		<label>Rue : </label> <label>${utilisateurConnecte.rue}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- cpo -->
		<label>Code postal : </label> <label>${utilisateurConnecte.codePostal}</label><br>
		<br>
	</div>
	<div class="container text-center">
		<!-- ville -->
		<label>Ville : </label> <label>${utilisateurConnecte.ville}</label><br>
		<br>
	</div>
	<form action="./ServletNewProfile" method="get">
		<div class="container text-center">
			<button class="btn btn-primary" type="submit" name="modif">Modifier
				compte</button>
			<a href="./" class="btn btn-primary">Retour accueil</a>
		</div>
	</form>
</body>
</html>