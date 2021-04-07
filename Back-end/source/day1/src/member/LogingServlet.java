package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LogingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저에서 한글 입력 시 인코딩
		request.setCharacterEncoding("UTF-8");
		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
		}

		// 요청 정보 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] locations = request.getParameterValues("location");

		String result = "";
		if (id.equals("user") && pw.equals("1234")) {
			result = "<h3 style=color:green>정상 로그인 되었습니다.</h3>";
		}
		else {
			result = "<h3 style=color:green>비정상 로그인 되었습니다.</h3>";
			result += "<h3><a href='http://127.0.0.1:9090/servletTest/loginform.html'> 로그인 창으로 이동</a></h3>";
		}

		// 응답 결과 브라우저 출력
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter o = response.getWriter();
		o.println(result); // 클라이언트 브라우
		System.out.println(result); // 서버 콘솔

		o.println("<h3>선택한 장소는 다음과 같습니다.</h3>");
		for (String loc : locations) {
			o.println(loc + "<br>");
		}
	}
}
