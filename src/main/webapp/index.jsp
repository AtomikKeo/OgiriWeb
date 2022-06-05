<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Discord大喜利</title>
</head>
<body>
<form action="/OgiriWeb/Login" method="post">
ユーザID:<input type="text" name="id"><br>
パスワード:<input type="password" name="pass"><br>
<c:out value="${errorMsg}" /><br>

<input type="submit" value="ログイン">
</form>
</body>
</html>