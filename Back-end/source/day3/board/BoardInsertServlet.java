package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/boardwrite")
public class BoardInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");// rows=10 cols = 100 
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");// 1111  
		BoardDAO dao = new BoardDAO();
		
		//writer 가 member 존재 id이면 writer를 세션에 저장  글쓰기 진행
		boolean memberresult = dao.getMember(writer); 
		//writer를 세션에 저장 
		HttpSession session = request.getSession();
		//1번째 요청 - 세션 생성 | 2번~ - 세션 재사용
		if(session.getAttribute("session_writer") == null) {
			session.setAttribute("session_writer", writer);
		}
		
		String result = "";
		if(memberresult) {
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setContents(contents);
			dto.setWriter(writer);
			dto.setPassword(Integer.parseInt(password));
			
			session.setAttribute("board", dto);
			
			dao.insertBoard(dto);
			result = "<h1>글쓰기 완료</h1>";
			result += "<a href='boardlist?page=1'> 리스트로 이동 </a>";
		}
		else {
			result = "<h1>회원가입부터 하세요</h1>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		
	}

}
