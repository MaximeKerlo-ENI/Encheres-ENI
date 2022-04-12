<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="./WEB-INF/include/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>
<body>
<header>
	<!-- include "standard" : recopie du code html "statique" -->
		<%@ include file="./WEB-INF/include/nav.html"%>
		<%@ include file="./WEB-INF/include/connection-status.jsp"%>
	</header>

	<h1 class="text-center">Liste des enchères</h1>
</body>
</html>