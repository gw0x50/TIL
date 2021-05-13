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
<h1>닮은 연예인 찾아주기</h1>
<%
	String faceResult = (String)request.getAttribute("faceResult");
	out.println(faceResult);
	String [] faceInfo = faceResult.split("\"faces\"");
	String [] celeInfo = faceInfo[1].split("\"celebrity\"");
	String one = celeInfo[celeInfo.length - 1];
	out.println(one + "<br>");
	int valueIndex = one.indexOf("\"value\":");
	int valueLength = "\"value\":".length();
	int confiIndex = one.indexOf("\"confidence\":");
	int confiLength = "\"confidence\":".length();
	
	out.println(one.substring(valueIndex + valueLength, confiIndex - 1) + "<br>");
	out.println(one.substring(confiIndex + confiLength, confiIndex + confiLength + 8) + "<br>");
%>
</body>
</html>