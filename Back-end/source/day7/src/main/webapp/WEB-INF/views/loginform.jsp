<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});//ready end
</script>
</head>
<body>
	<h1>로그인 폼</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		아이디 <input type="text" name="id"><br>
		암호 <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>