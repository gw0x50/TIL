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
<%
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String file : filelist) {
%>
		<a href="/face2?image=<%=file%>"><%=file%>(얼굴인식)</a> <img src="/images/<%=file%>" width=100 height=100><br>
<%
	}
%>
</body>
</html>