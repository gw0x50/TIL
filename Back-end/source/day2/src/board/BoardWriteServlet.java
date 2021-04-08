package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardwrite")
public class BoardWriteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		String writer = request.getParameter("writer");
		dto.setWriter(writer);
		dto.setPassword(Integer.parseInt(request.getParameter("password")));
		//String password = request.getParameter("password");

		BoardDAO dao = new BoardDAO();
		String result = "";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter o = response.getWriter();
		if(dao.getMember(writer)) {
			dao.insertBoard(dto);	
			result += "<h1>글 쓰기 완료</h1>";
		}
		else {
			result += "<h1>회원가입 부터 하세요.</h1>";
		}
		result += "<a href='boardlist'>리스트로 이동</a>";

		o.println(result);
	}

}
