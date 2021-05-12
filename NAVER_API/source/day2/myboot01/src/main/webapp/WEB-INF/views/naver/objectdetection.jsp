<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/jquery-3.2.1.min.js"></script>
<% String result = (String)request.getAttribute("objectdetectionResult");%>
<script>
$(document).ready(function() {
	var json = JSON.parse('<%=result%>');
	
	$("#result").text('<%=result%>');
	$("#count").text("탐지 객체 수 = " + json.predictions[0].num_detections + "개");
	$("#names").text("객체 이름 =  " + json.predictions[0].detection_names);
	$("#confidence").text("확률 = ");
	for (var i = 0; i < json.predictions[0].num_detections; i++) {
		$("#confidence").append(parseInt(parseFloat(json.predictions[0].detection_scores[i]) * 100) + "%, ");
	}
	// 캔버스에 이미지 로드
	var imagecanvas = document.getElementById("imagecanvas");
	var context = imagecanvas.getContext("2d");
	context.fillStyle = "red";
	context.font = "15px batang";
	context.strokeStyle = "green";
	context.lineWidth = 3;
	
	// 이미지 로드
	var image = new Image();
	image.src = '/faceimages/<%=request.getParameter("image")%>';
	image.onload = function() {
		context.drawImage(image, 0, 0, image.width, image.height);
		var names = json.predictions[0].detection_names;
		var confidence = json.predictions[0].detection_scores;
		var boxes = json.predictions[0].detection_boxes;
		for(var i = 0; i < names.length; i++) {
			if(confidence[i] >= 0.9) {
				var x1 = boxes[i][0] * image.width; // 가로 시작 지점
				var y1 = boxes[i][1] * image.height; // 세로 시작 지점
				var x2 = boxes[i][2] * image.width; // 가로 종료 지점
				var y2 = boxes[i][3] * image.height; // 세로 종료 지점
			
				// 이름 : xx% 출력
				context.fillText(names[i] + " : " + parseInt(confidence[i] * 100) + "%", x1 + 10, y1 + 10);
			
				// 사각형 그려서 출력
				context.strokeRect(x1, y1, x2 - (x1 * 3), y2 - y1)
			}
		}
	}
});
</script>
<%--
<script>
window.onload = function() {
	var result = document.getElementById("result");
	var count = document.getElementById("count");
	var names = document.getElementById("names");
	var confidence = document.getElementById("confidence");
	
	var json = JSON.parse('<%=result%>');
	result.innerHTML =  '<%=result%>';
	count.innerHTML = "탐지 객체 수 = " + json.predictions[0].num_detections + "개";
	names.innerHTML = "객체 이름 =  " + json.predictions[0].detection_names;
	confidence.innerHTML = "확률 = ";
	for(var i = 0; i < json.predictions[0].detection_scores.length; i++){
		confidence.innerHTML += parseInt(parseFloat(json.predictions[0].detection_scores[i]) * 100) + "% ,";
	}
}
</script>
--%>
</head>
<body>

<div id="result"></div>
<div id="count"></div>
<div id="names"></div>
<div id="confidence"></div>
<canvas id="imagecanvas" width=500 height=500 style="border : 2px solid red"></canvas>
</body>
</html>