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
			<h3>ENI-Encheres</h3>
		</div>
		<div class="col-5 text-end">
			<%@ include file="./WEB-INF/include/connection-status.jsp"%>
		</div>
	</div>
			
	<div class="mt-5 container text-center">
		<!-- pseudo -->
		<label>Pseudo : </label>
		<label>[PLACEHOLDER] Pseudo</label><br><br>
		<!-- nom -->
		<label>Nom : </label>
		<input type="text" name="nom"><br><br>
		<!-- prenom -->
		<label>Prénom : </label>
		<input type="text" name="prenom"><br><br>
		<!-- mail -->
		<label>Mail : </label>
		<input type="text" name="mail"><br><br>
		<!-- tel -->
		<label>Téléphone : </label>
		<input type="text" name="tel"><br><br>
		<!-- rue -->
		<label>Rue : </label>
		<input type="text" name="rue"><br><br>
		<!-- cpo -->
		<label>Code postal : </label>
		<input type="text" name="cpo"><br><br>
		<!-- ville -->
		<label>Ville : </label>
		<input type="text" name="ville"><br><br>
		<!-- <button class="btn btn-primary" type="submit" name="modif">Modifier</button> -->
	</div>
</body>
</html>