<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Accueil" />
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
			
	<h1 class="text-center">Liste des enchères</h1>
	
	<div class="container col-5">
		<label>Filtres : </label>
		<div>
		  <div class="form-outline">
		    <input type="search" id="form1" class="form-control" />
		  </div>
		  <button type="button" class="btn btn-primary">
		    <i class="fas fa-search"></i>
		  </button>
		</div><br>
		<label>Catégorie : </label>
		<select class="form-select" aria-label="Default select example">
			<option>placeholder
		</select>				
	</div>
	<div class="container col-5">
			<button class="btn btn-primary">Rechercher</button>
	</div>
	<div>
		<!-- Liste article ici -->
	</div>
	
</body>
</html>