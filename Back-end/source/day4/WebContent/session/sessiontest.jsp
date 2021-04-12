<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
<%
String session_id ="";
if(session.getAttribute("session_id")!=null){
	session_id = (String)session.getAttribute("session_id");
}
else {
	out.println("로그인을 부탁합니다.");
}
%>
<h1><%=session_id%> 회원님 로그인 하셨습니다.</h1>
<h3><a href="sessiontest2.jsp">내 후기 보러 가기</h3>
<h3><a href="sessiontest3.jsp">내 정보 보러 가기</h3>
<h3><a href="sessiontest4.jsp">로그 아웃 하러 가기</h3>
<h3><a href="/jsp/sessiontest?id=jsp">로그인 하러 가기</h3>
</body>
</html>