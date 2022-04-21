<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<img alt="" src="./img/logo_ENI.png" width="50" height="50"> <strong>ENI-Encheres</strong>
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
		</div>
		<br> <label>Catégorie : </label> <select class="form-select"
			aria-label="Default select example">
			<option selected>Toutes</option>
			<c:forEach var="categorie" items="${listeCategorie}">
				<option>${categorie.libelle}</option>
			</c:forEach>
		</select>
	</div>
	<div class="container col-5">
		<button class="btn btn-primary">Rechercher</button>
	</div>
	<!-- achats/ventes -->
	<section>
		<c:choose>
			<c:when test="${utilisateurConnecte != null}">
				<div class="row">
					<div class="container col-4">
						<div class="form-check form-check-inline">
							<input checked class="form-check-input" type="radio"
								name="flexRadioDefault" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1"> Achats
							</label>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckDefault"> <label class="form-check-label"
									for="flexCheckDefault"> Enchères ouvertes </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked"> <label class="form-check-label"
									for="flexCheckChecked"> Mes enchères </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked"> <label class="form-check-label"
									for="flexCheckChecked"> Mes enchères remportées </label>
							</div>
						</div>
					</div>
					<div class="container col-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio"
								name="flexRadioDefault" id="flexRadioDefault1"> <label
								class="form-check-label" for="flexRadioDefault1"> Mes
								ventes </label>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckDefault"> <label class="form-check-label"
									for="flexCheckDefault"> Mes ventes en cours </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked"> <label class="form-check-label"
									for="flexCheckChecked"> Ventes non débutées </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked"> <label class="form-check-label"
									for="flexCheckChecked"> Ventes terminées </label>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div></div>
			</c:otherwise>
		</c:choose>
	</section>
	<br>
	<div class="row container">
		<c:forEach var="article" items="${listeArticle}">
			<div class="col-6 mb-3">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="..."><br> <label><b>${article.nomArticle}</b></label><br>
						<label>Prix : </label><label>${article.miseAPrix}</label><br>
						<label>Fin de l'enchère : </label><label>${article.dateFinEncheres}</label><br>
						<label>Vendeur : </label><a href=""><label>${article.utilisateur.pseudo}</label></a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>