<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getAttribute("model") %></h1>
<h1>${model}</h1>
<hr>
<h1><%=request.getAttribute("model2") %></h1>
<h1>${model2}</h1>
</body>
</html>