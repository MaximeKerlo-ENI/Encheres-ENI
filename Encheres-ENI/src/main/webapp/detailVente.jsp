<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Detail vente" />
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
	
	<h1 class="text-center">Détail vente</h1>
	
	<div class="row">
		<div class="col-3 ms-5 mt-3">
			Photo article ici
		</div>
		<div class="col-6 ms-5 mt-3">
			<h5>[PLACEHOLDER] Nom article</h5><br><br>
			<label class="align-top">Description : </label>
			<textarea readonly name="description" rows="3" cols="18"></textarea><br><br>
			<label>Catégorie : </label><label>[PLACEHOLDER] Catégorie</label><br><br>
			<label>Meilleure offre : </label><label>[PLACEHOLDER] Offre</label><br><br>
			<label>Fin de l'enchère : </label><label>[PLACEHOLDER] Fin enchère</label><br><br>
			<label>Retrait : </label><label>[PLACEHOLDER] Retrait</label><br><br>
			<label>Vendeur : </label><label>[PLACEHOLDER] Vendeur</label><br><br>
			<label>Ma proposition : </label><input type="number" name="proposition">
			<button class="btn btn-primary">Enchérir</button>
		</div>
	</div>
</body>
</html>