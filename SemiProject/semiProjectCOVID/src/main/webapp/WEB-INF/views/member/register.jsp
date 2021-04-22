<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!--  jquery  --> 
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--  알람 swal  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!-- 다음 주소 찾기  -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 회원가입 관련 script -->
<script src="/resources/js/register.js"></script>
<!-- footer css -->
<link rel="stylesheet" href="/resources/css/footer.css" type="text/css">
<!-- member 관련 css -->
<link rel="stylesheet" href="/resources/css/member.css" type="text/css">
<!-- header css -->
<link rel="stylesheet" href="/resources/css/header.css" type="text/css">
</head>
<body>
<div class="wrap">
	<jsp:include page="/WEB-INF/views/frame/header_no_userarea.jsp"/>
	<div class="container">
		<div class="member_section">
			<div class="member_title">
				<h1>회원 가입</h1>
			</div>
			<div class="member_form">
				<form action="/member/register" id="registerForm" method="post">
					<div class="input">
						<input class="input-text" type="text" name="id" id="id" placeholder="아이디">
					</div>
					<div class="check">
						<span id="idCheckMessage"></span><br>
					</div>
					<input class="input-text" type="hidden" id="idValidCheck" value="false">
					<div class="input">
						<input class="input-text" type="password" name="password" id="password" placeholder="비밀번호">
					</div>
					<div class="input">
						<input class="input-text" type="password" id="passwordCheck" placeholder="비밀번호 확인">
					</div>
					<div class="check">
						<span id="passwordCheckMessage"></span><br>
					</div>
					<input class="input-text" type="hidden" id="passwordEqualCheck" value="false">
					<div class="input">
						<input class="input-text" type="text" name="name" id="name" placeholder="이름"><br>
					</div>
					<div class="input">
						<input class="input-text" type="text" name="phone" id="phone" placeholder="연락처"><br>
					</div>
					<div class="input">
						<input class="input-text" type="text" name="email" id="email" placeholder="이메일"><br>
					</div>
					<div class="input">
						<input class="input-text" type="text" name="address" id="address" placeholder="주소" readonly>
						<input class="input-text" type="button" id="searchAddr" value="주소 검색"><br>
					</div>
					<div class="input">
						<input class="input-text" type="text" name="detailAddress" id="detailAddress" placeholder="상세주소"><br>
					</div>
					<div class="input">
						<input class="input-text" type="submit" value="가입하기">
						<input class="input-text" type="button" value="돌아가기" onClick="location.href='/'">
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/frame/footer.jsp"/>
</div>
</body>
</html>