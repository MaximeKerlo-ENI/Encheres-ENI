<head>

 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<meta charset="UTF-8">
<style><%@include file="/css/style.css"%></style>
<title>${param.titre}</title>
<!--  <title>Test 3</title>
 -->
<%-- parce qu'on utilise des sous -url /admin on doit utiliser : ${pageContext.request.contextPath} : réference vers l'url de l'application : http://localhost:8080/DemoSessionFiltre --%>



<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

 </head>