<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Nouveau profil" />
</jsp:include>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<a href="./"><img title="Retour à l'accueil"
				src="./img/logo_ENI.jpg" width="50" height="50"></a> <strong>ENI-Encheres</strong>
		</div>
	</div>

	<section>
		<c:choose>
			<c:when test="${utilisateurConnecte == null}">
				<!-- version nouveau profil -->
				<h1 class="text-center">Nouveau profil</h1>

				<form action="./ServletNewProfile" method="post">
					<div class="row">
						<div class="container text-center">
							<label class="mt-3">Pseudo : </label> <input type="text"
								name="pseudo"> <label class="ms-3">Nom : </label> <input
								type="text" name="nom">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Prénom : </label> <input type="text" name="prenom">
							<label class="ms-3">Email : </label> <input type="text"
								name="mail">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Téléphone : </label> <input type="text" name="tel">
							<label class="ms-3">Rue : </label> <input type="text" name="rue">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Code postal : </label> <input type="text" name="cpo">
							<label class="ms-3">Ville : </label> <input type="text"
								name="ville">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Mot de passe: </label> <input type="password" name="pwd">
							<label class="ms-3">Confirmation: </label> <input type="password"
								name="confirm">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<button class="btn btn-lg btn-primary" type="submit">Créer</button>
							<a href="./" class="btn btn-lg btn-primary">Annuler</a>
						</div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<!-- version modif profil -->
				<h1 class="text-center">Modifier profil</h1>

				<form action="./ServletProfile" method="post">
					<div class="row">
						<div class="container text-center">
							<label class="mt-3">Pseudo : </label> <input type="text"
								name="pseudo-mod" value="${utilisateurConnecte.pseudo}">
							<label class="ms-3">Nom : </label> <input type="text"
								name="nom-mod" value="${utilisateurConnecte.nom}">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Prénom : </label> <input type="text" name="prenom-mod"
								value="${utilisateurConnecte.prenom}"> <label
								class="ms-3">Email : </label> <input type="text" name="mail-mod"
								value="${utilisateurConnecte.email}">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Téléphone : </label> <input type="text" name="tel-mod"
								value="${utilisateurConnecte.telephone}"> <label
								class="ms-3">Rue : </label> <input type="text" name="rue-mod"
								value="${utilisateurConnecte.rue}">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Code postal : </label> <input type="text" name="cpo-mod"
								value="${utilisateurConnecte.codePostal}"> <label
								class="ms-3">Ville : </label> <input type="text"
								name="ville-mod" value="${utilisateurConnecte.ville}">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Mot de passe actuel : </label> <input readonly type="password"
								name="mdp-mod" value="${utilisateurConnecte.motDePasse}">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Nouveau mot de passe: </label> <input type="password"
								name="newPwd"> <label class="ms-3">Confirmation:
							</label> <input type="password" name="confirm-mod">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<label>Credit : </label> <label>${utilisateurConnecte.credit}</label>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="container text-center">
							<button class="btn btn-lg btn-primary" type="submit">Enregistrer</button>
							<a href="./" class="btn btn-lg btn-primary">Annuler</a>
						</div>
					</div>
				</form>
				<form action="./ServletProfile" method="post">
					<div class="row">
						<div class="container text-center">
							<button class="btn btn-lg btn-danger" type="submit" value="delete">Supprimer compte</button>
						</div>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>