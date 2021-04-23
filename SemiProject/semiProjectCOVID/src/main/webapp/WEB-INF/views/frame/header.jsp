<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="header_inner">
		<div class="logo">
			<img class="logo_img" src="/resources/images/logo.png" onclick="location.href='/'">
		</div>
		<div class="user_area">
			<% if (session.getAttribute("id") != null) { %>
				<div class="infomation">
					환영합니다. <%=session.getAttribute("name")%>(<%=session.getAttribute("id")%>)님.&nbsp;&nbsp;
				</div>
				<div class="user_action">
					<button type="button" class="btn" onclick="location.href='/member/logout'">로그아웃</button>
					<button type="button" class="btn" onclick="location.href='/member/update'">정보수정</button>
				</div>
			<% } else { %>
				<div class="user_action">
					<form action="/member/login" id="loginForm" method="post">
						ID : <input type="text" name="id" id="id"> &nbsp;
						PW : <input type="password" name="password" id="password">&nbsp;&nbsp;
						<input type="submit" class="btn" value="로그인">
						<button type="button" class="btn" onclick="location.href='/member/register'">회원가입</button>
					</form>
				</div>
			<% } %>
		</div>
	</div>
</div>