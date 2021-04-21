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
<!-- 다음 주소 찾기 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 회원 정보 수정 관련 script -->
<script src="/resources/js/update.js"></script>
</head>
<body>
<form action="/member/update" id="registerForm" method="post">
	<input type="text" name="id" id="id" placeholder="아이디" value="${vo.id}" readonly><br>
	<input type="password" name="password" id="password" placeholder="비밀번호"><br>
	<input type="password" id="passwordCheck" placeholder="비밀번호 확인"><span id="passwordCheckMessage"></span><br>
	<input type="hidden" id="passwordEqualCheck" value="false">
	<input type="text" name="name" id="name" placeholder="이름" value="${vo.name}"><br>
	<input type="text" name="phone" id="phone" placeholder="연락처" value="${vo.phone}"><br>
	<input type="text" name="email" id="email" placeholder="이메일" value="${vo.email}"><br>
	<input type="text" name="address" id="address" placeholder="주소" value="${vo.address}" readonly>
	<input type="button" id="searchAddr" value="주소 검색"><br>
	<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소" value="${vo.detailAddress}"><br>
	<input type="submit" value="수정하기">
</form>
<input type="button" value="돌아가기" onClick="location.href='/'">
<form action="/member/delete" id="deleteForm" method="post">
	<input type="hidden" name="id" value="${vo.id}" readonly>
	<input type="submit" value="삭제하기">
</form>

</body>
</html>