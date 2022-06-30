<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お題</title>
</head>
<body>
<c:out value="${loginAccount.name}"/>さん
<c:forEach var="odai" items="${odaiList}">
	お題:${odai.theme}
</c:forEach>
 <h3><font color="white">IBM Cognos Dashboard Embeddedデモ  </font></h3>
 <h5><font color="white">APIとjsを使ってアプリの中にCognosのダッシュボードを組み込めます</font></h5>
 <span id="sessionCode">SN2fb8fbab110edc68a6e413681344c277</span><br>

 <button id="go" class="button-primary">ブランクのDashboardを起動</button>
 <hr />
 <div id="containerDivId" style="height:800px; width:100%;">
 </div>
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 <script src="/OgiriWeb/js/CognosApi.js"></script>
 <script src="/OgiriWeb/js/client.js"></script>
</body>
</html>