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
<%
String [] langs = {"Kor", "Eng", "Jpn", "Chn"};
String [] langnames = {"한국어", "영어", "일본어", "중국어"};
%>
</script>
</head>
<body>
<h1> stt 서비스를 위한 파일 선택 </h1>
<form action="/speech">
	언어 선택 : 
	<%for(int i = 0; i < langs.length; i++) { %>
		<input type="radio" name="lang" value="<%=langs[i]%>"> <%=langnames[i]%>
	<%}%>
	<br> 파일 선택 : 
	<select name="image">
<%
	String[] filelist = (String[])request.getAttribute("filelist");
	for(String file : filelist) {
		String[] f_split = file.split("[.]");
		String ext = f_split[f_split.length-1];
		if(ext.equals("mp3")) {
%>
			<option value="<%=file%>"><%=file%></option>
<%	
		}
	}
%>
	</select>
	<input type="submit" value="결과보기">
</form>

			

</body>
</html>