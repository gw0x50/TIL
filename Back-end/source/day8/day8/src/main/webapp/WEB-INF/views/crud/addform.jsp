<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});//ready end
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/crud/add" method="post">
		제목 : <input type="text" name="title"><br>
		내용 : <textarea rows="5" cols="20" name="contents"></textarea><br>
		작성자 : <input type="text" name="writer"><br>
		<input type="submit" value="글쓰기"><br>
	</form>
</body>
</html>