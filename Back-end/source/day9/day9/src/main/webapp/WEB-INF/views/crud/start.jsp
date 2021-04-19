<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});//ready end
</script>
</head>
<body>
<h1>제 홈페이지의 첫 화면 입니다.</h1>
<a href="<%=request.getContextPath() %>/crud/list">게시물 리스트 보러가기</a><br>
<a href="<%=request.getContextPath() %>/crud/add">게시물 작성하기</a><br>
<a href="<%=request.getContextPath() %>/crud/update">게시물 수정하기</a><br>
<a href="<%=request.getContextPath() %>/crud/delete">게시물 삭제하기</a><br>
</body>
</html>