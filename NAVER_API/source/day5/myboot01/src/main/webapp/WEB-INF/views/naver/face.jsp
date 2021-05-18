<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONObject"%>
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
	JSONObject obj = new JSONObject(faceResult);
	Object imsi = obj.get("faces");
	JSONArray faces = (JSONArray)imsi;
	for(Object cele : faces) {
		JSONObject celebrity = (JSONObject)((JSONObject)cele).get("celebrity");
		BigDecimal confidence = (BigDecimal)celebrity.get("confidence");
		out.println("닮은 연예인 이름 = " + celebrity.get("value") + ", 닮은 확률 = " + Math.round(confidence.doubleValue() * 100) + "%<br>");
	}
%>
</body>
</html>