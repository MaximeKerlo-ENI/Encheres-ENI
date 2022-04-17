<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Nouvelle vente" />
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
			
	<h1 class="text-center">Nouvelle vente</h1>
	
	<div class="row">
		<div class="col-3 ms-5 mt-3">
			<img src="...">
		</div>
		<div class="col-4 ms-5 mt-3">
			<!-- nom article -->
			<label>Article : </label>
			<input type="text" name="nom"><br><br>
			<!-- dezcription article -->
			<label class="align-top">Description : </label>
			<textarea name="description" rows="3" cols="18"></textarea><br><br>
			<!-- categorie article -->
			<label>Catégorie</label>
			<select class="w-75" name="categorie">
				<option>${libelle}</option>
			</select><br><br>
			<!-- upload photo article -->
			<label>Photo de l'article</label>
			<button class="btn btn-success" name="upload">Charger image</button><br><br>
			<!-- mise à prix article -->
			<label>Mise à prix : </label>
			<input type="number" name="price"><br><br>
			<!-- date début vente -->
			<label>Début de l'enchère : </label>
			<input type="date" name="start"><br><br>
			<!-- date fin vente -->
			<label>Fin de l'enchère : </label>
			<input type="date" name="end"><br><br>
			<!-- retrait -->
			<label>Retrait</label>
			<div class="border border-dark"><br>
				<!-- rue retrait -->
				<label class="ms-2">Rue : </label>
				<input type="text" name="rue"><br><br>
				<!-- code postal retrait -->
				<label class="ms-2">Code postal : </label>
				<input class="w-25" type="text" name="cpo"><br><br>
				<!-- ville retrait -->
				<label class="ms-2">Ville : </label>
				<input type="text" name="ville"><br><br>
			</div><br>
			<!-- boutons enregistrer/annuler -->
			<button class="btn btn-primary" type="submit" name="enregistrer">Enregistrer</button>
			<a href="./" class="btn btn-primary">Annuler</a>
			<!-- bouton delete vente ici -->		
		</div>
	</div>
	
	
</body>
</html>