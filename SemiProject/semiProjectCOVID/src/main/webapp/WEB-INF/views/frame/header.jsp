<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
<%if(session.getAttribute("id")!=null) { %>
	환영합니다 <%=session.getAttribute("name")%>님.	
	<button type="button" onclick="location.href='/member/logout'">로그아웃</button>
	<button type="button" onclick="location.href='/member/update'">정보수정</button>
<% 
}
else {
%>
	<form action="/member/login" id="loginForm" method="post">
		아이디 : <input type="text" name="id" id="id">
		비밀번호 : <input type="password" name="password" id="password">
		<input type="submit" value="로그인">
		<button type="button" onclick="location.href='/member/register'">회원가입</button>
	</form>
<% } %>
</div>