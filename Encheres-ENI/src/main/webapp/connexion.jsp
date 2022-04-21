<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- include jsp : recopie une jsp à laquelle on peut preciser des paramètres -->
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Connexion" />
</jsp:include>
<body>
	<div class="row ms-5 mt-3">
		<div class="col-6">
			<a href="./"><img src="./img/logo_ENI.png" width="50" height="50"></a>
			<strong>ENI-Encheres</strong>
		</div>
	</div>
		
	<!-- on affiche les éventuelles erreurs -->
	<p class="erreur">${erreur}</p>

	<form action="./connexion" method="post">
		<div class="container text-center mx-auto px-auto">
			<label>Pseudo : </label>
			<input type="text" name="username"/>
		</div>
		<br>
		<div class="container text-center mx-auto px-auto">
			<label>Mot de passe: </label>
			<input type="password" name="password"/>
		</div>
	
		<br>
		<div class="container text-center mx-auto pe-5 ps-0">
			<button type="submit" class="btn btn-primary">Connexion</button>
		</div>
	</form>
	<div class="container text-center mx-auto pe-5 ps-0">
		<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
		<label class="form-check-label" for="flexCheckDefault">
		Se souvenir de moi
		</label>
	</div>
	<div class="container text-center mx-auto pe-5 ps-0">
		<a href="">Mot de passe oublié?</a>
	</div>
		
	<form action="./ServletNewProfile" method="GET">
		<div class="container text-center mx-auto pe-5 ps-0">
			<button type="submit" class="btn btn-primary">Créer un nouveau compte</button>	
		</div>
	</form>
</body>
</html>