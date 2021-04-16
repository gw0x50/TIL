<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});//ready end
</script>
<style>
li {
	background-color: pink;
	margin: auto;
	width: 300px;
}
</style>
</head>
<body>
<ul>
	<c:forEach items="${boardlist}" var="board">
		<li>${board.seq} <a href="<%=request.getContextPath()%>/boarddetail?seq=${board.seq}">${board.title}</a> ${board.writer} ${board.viewcount}</li>
	</c:forEach>
</ul>
</html>