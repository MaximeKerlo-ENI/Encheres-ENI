<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
	<c:choose>
	<c:when test="${utilisateurConnecte != null}">
		Vous êtes connecté avec : ${utilisateurConnecte.username}
		<!-- formulaire de déconnexion -->
		<%-- parce qu'on utilise des sous -url /admin on doit utiliser : ${pageContext.request.contextPath} : réference vers l'url de l'application : http://localhost:8080/DemoSessionFiltre --%>
		<%@ include file="/WEB-INF/include/nav.html"%>
	</c:when>
	<c:otherwise>
	<%-- parce qu'on utilise des sous -url /admin on doit utiliser : ${pageContext.request.contextPath} : réference vers l'url de l'application : http://localhost:8080/DemoSessionFiltre --%>
		<a href="${pageContext.request.contextPath}/connexion">Connexion</a>
	</c:otherwise>
	</c:choose>	
</section>