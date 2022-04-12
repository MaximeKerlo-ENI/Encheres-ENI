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
</body>
</html>