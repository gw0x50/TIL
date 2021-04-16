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
	${boarddetail.seq}<br>
	${boarddetail.title}<br>
	${boarddetail.contents}<br>
	${boarddetail.writer}<br>
	${boarddetail.time}<br>
	${boarddetail.password}<br>
	${boarddetail.viewcount}<br>
</body>
</html>