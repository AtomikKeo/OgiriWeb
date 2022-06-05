<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お題</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/test.js"></script>
</head>
<body>
<c:out value="${loginAccount.name}"/>さん
<c:forEach var="odai" items="${odaiList}">
	お題:${odai.theme}
</c:forEach>
<p id="realtime"></p>
</body>
</html>