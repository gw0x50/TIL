<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${10}</h1>
<h1>${10.99}</h1>
<h1>${true}</h1>
<h1>${"e1 문자열 입니다."}</h1>
<h1>${'e1 문자열 입니다.'}</h1>
<h1>${null}</h1>
<h1>끝</h1>
<br>
<h1>덧셈 : ${10 + 20}</h1>
<h1>덧셈 : ${'10' + 20}</h1>
<%-- <h1>덧셈 : ${'el' + 20}</h1>  --%>
<h1>덧셈 : ${null + 20}</h1>
<h1>나눗셈 : ${20 div 10 }</h1>
<h1>나머지 : ${20 mod 10}</h1>
<h1>비교 : ${20 < 10}</h1>
<h1>비교 : ${20 lt 10}</h1>
<h1>비교 : ${20 == 10}</h1>
<h1>비교 : ${20 eq 10}</h1>
<h1>비교 : ${20 != 10}</h1>
<h1>비교 : ${20 ne 10}</h1>
<h1>${20 != 10?"같지않다" : "같다"}</h1>
<h1>${i = null}</h1>
<h1>${empty i }</h1>
${j = "jsp" }
<%= pageContext.getAttribute("j") %>
</body>
</html>