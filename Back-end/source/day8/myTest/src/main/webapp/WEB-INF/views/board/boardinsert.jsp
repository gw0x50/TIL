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
<form action="<%=request.getContextPath()%>/boardinsert" method="post">
		<table border="3">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="3" cols="60" name="contents"></textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="radio" name="writer" value="oracle">oracle
					<input type="radio" name="writer" value="java">java
					<input type="radio" name="writer" value="spring">spring
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기 완료"></td>
			</tr>
		</table>
	</form>
</body>
</html>