<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");	
	}
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id.equals("jsp") && pw.equals("jsp")) {
		%>
		<h1>정상 로그인 되었습니다.</h1>
		<%
		String[] locs = request.getParameterValues("location");
		for(String loc : locs) {
			%><h3><%
			out.println(loc);
			%></h3><%
		}
	}
	else {
		%>
		<a href="loginform.jsp">로그인 폼으로 이동</a>
		<%
		RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
		rd.forward(request, response);
	}
%> --%>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");	
	}
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id.equals("jsp") && pw.equals("jsp")) {
		out.println("<h1>정상 로그인 되었습니다.</h1>");
		String[] locs = request.getParameterValues("location");
		for(String loc : locs) {
			out.println("<h3>" + loc +"</h3>");
		}
	}
	else {
		out.println("<a href='loginform.jsp'>로그인 폼으로 이동</a>");
		RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
		rd.forward(request, response);
	}
%>
<jsp:forward page="loginform.jsp">
	<jsp:param value="아이디 인증받지 못했습니다." name="message"/>
</jsp:forward>
</body>
</html>