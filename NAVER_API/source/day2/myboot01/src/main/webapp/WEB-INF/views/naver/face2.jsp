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
<h1>얼굴 인식</h1>
<%
	String faceResult2 = (String)request.getAttribute("faceResult2");
	String image = request.getParameter("image");
	JSONObject obj = new JSONObject(faceResult2);
	JSONArray faces = (JSONArray)obj.get("faces");
	boolean find = false;
	
	for(Object one : faces) {
		find = true;
		JSONObject roi = (JSONObject)((JSONObject)one).get("roi");
		int x = (int)roi.get("x");
		int y = (int)roi.get("y");
		int width = (int)roi.get("width");
		int height = (int)roi.get("height");
		
		out.println("얼굴 x 좌표 = " + x + ", y 좌표 = " + y + ", 가로 크기 = " + width + ", 세로 크기 = " + height + "<br>");
	}
	
	for(int i = 0; i < faces.length(); i++) {
		JSONObject face = (JSONObject)faces.get(i);
		JSONObject gender = (JSONObject)face.get("gender");
		String genderValue = (String)gender.get("value");
		JSONObject age = (JSONObject)face.get("age");
		String ageValue = (String)age.get("value");
		JSONObject emotion = (JSONObject)face.get("emotion");
		String emotionValue = (String)emotion.get("value");
		
		out.println("표정 = " + emotionValue + ", 성별 = " + genderValue + ", 나이 = " + ageValue + "<br>");
	}
	
%>
<img src="/images/<%=image%>">
</body>
</html>