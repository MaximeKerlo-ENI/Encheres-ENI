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
			<img alt="" src="./img/logo_ENI.jpg" width="50" height="50">
			<strong>ENI-Encheres</strong>
		</div>
		<div class="col-5 text-end">
			<%@ include file="./WEB-INF/include/connection-status.jsp"%>
		</div>
	</div>
			
	<div class="container text-center">
		<!-- pseudo -->
		<label>Pseudo : </label>
		<label>${pseudo}</label><br><br>
	</div>
	<div class="container text-center">
		<!-- nom -->
		<label>Nom : </label>
		<input type="text" name="nom" value="${nom}"><br><br>
	</div>
	<div class="container text-center">
		<!-- prenom -->
		<label>Prénom : </label>
		<input type="text" name="prenom" value="${prenom}"><br><br>
	</div>
	<div class="container text-center">
		<!-- mail -->
		<label>Mail : </label>
		<input type="text" name="mail" value="${mail}"><br><br>
	</div>
	<div class="container text-center">
		<!-- tel -->
		<label>Téléphone : </label>
		<input type="text" name="tel" value="${tel}"><br><br>
	</div>
	<div class="container text-center">
		<!-- rue -->
		<label>Rue : </label>
		<input type="text" name="rue" value="${rue}"><br><br>
	</div>
	<div class="container text-center">
		<!-- cpo -->
		<label>Code postal : </label>
		<input type="text" name="cpo" value="${cpo}"><br><br>
	</div>
	<div class="container text-center">
		<!-- ville -->
		<label>Ville : </label>
		<input type="text" name="ville" value="${ville}"><br><br>
	</div>
	<div class="container text-center">
		<!-- "if" si pseudo session = pseudo utilisateur
		<!--  <button class="btn btn-primary" type="submit" name="modif">Modifier</button> -->
		<!-- fin if -->
		<a href="./" class="btn btn-primary" name="modif">Retour accueil</a>
	</div><br>
	<div class="container text-center">
		<button class="btn btn-danger" type="submit" name="modif">Supprimer compte</button>
	</div>
</body>
</html>