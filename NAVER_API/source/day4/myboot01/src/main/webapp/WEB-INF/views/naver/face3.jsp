<%@page import="java.math.BigDecimal"%>
<%@page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	String image = request.getParameter("image"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
window.onload = function() {
	var samplecanvas = document.getElementById("samplecanvas");
	var samplecontext = samplecanvas.getContext("2d");
	var image = new Image();
	image.src = "/faceimages/<%=image%>";
	image.onload = function() {
		samplecontext.drawImage(image, 0, 0, image.width, image.height);
<%
		String faceResult2 = (String)request.getAttribute("faceResult2");
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
		
			// out.println("얼굴 x 좌표 = " + x + ", y 좌표 = " + y + ", 가로 크기 = " + width + ", 세로 크기 = " + height + "<br>");
%>
			var x = <%=x %>;
			var y = <%=y %>;
			var width = <%=width %>;
			var height = <%=height %>;
	
			var faceimage = samplecontext.getImageData(x, y, width, height);
			// 색상 반전 - 이미지 구성하는 기본 단위 점 - pixel - 1개(4개 구성 성분 - rgbi) - 0 ~ 255 사이 ff00ff
			var data = faceimage.data;
			var numpixels = data.length;
			for(var i = 0; i < numpixels; i += 4) {
				data[i] = 255 - data[i];
				data[i + 1] = 255 - data[i + 1];
				data[i + 2] = 255 - data[i + 2];
			}
			
			var targetcanvas = document.getElementById("targetcanvas");
			var targetcontext = targetcanvas.getContext("2d");
			targetcontext.putImageData(faceimage, 50, 50);
<%
		} // for end
%>
	} // image onload end
} // window onload end
</script>
</head>
<body>
<h1> 이미지 전체 캔버스 </h1>
<canvas id="samplecanvas" width=500 height=500 style="border : solid 2px pink"></canvas>
<h1> 얼굴만 캔버스 </h1>
<canvas id="targetcanvas" width=300 height=300 style="border : solid 2px pink"></canvas>
</body>
</html>