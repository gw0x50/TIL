<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="board.BoardDTO" scope="request"/>
<jsp:setProperty property="title" name="dto"/>
<jsp:setProperty property="contents" name="dto"/>
<jsp:setProperty property="writer" name="dto"/>
<jsp:setProperty property="password" name="dto"/>

제목 확인 : <jsp:getProperty property="title" name="dto"/><br>
내용 확인 : <jsp:getProperty property="contents" name="dto"/><br>
작성자 확인 : <jsp:getProperty property="writer" name="dto"/><br>
비밀번호 확인 : <jsp:getProperty property="password" name="dto"/><br>

</body>
</html>