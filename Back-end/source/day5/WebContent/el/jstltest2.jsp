<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty param.id }">
	<h1>아이디 입력은 필수입니다.</h1>
</c:if>
<c:if test="${!empty param.id }">
	<h1>${param.id} 회원님이 입장하셨습니다.</h1>
	<c:choose>
		<c:when test="${param.age <= 13}">
			<h3 style="color:green">초등학생 입니다.</h3>
		</c:when>
		<c:when test="${param.age <= 16}">
			<h3 style="color:purple">중학생 입니다.</h3>
		</c:when>
		<c:when test="${param.age <= 19}">
			<h3 style="color:blue">고등학생 입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3 style="color:pink">성인 입니다.</h3>
		</c:otherwise>
	</c:choose>
</c:if>
</body>
</html>