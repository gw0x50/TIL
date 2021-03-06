package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDTO;

@WebServlet("/forward1")
public class Forward1Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//response.setContentType("text/html;charset=UTF-8");
		//response.getWriter().println("<h1>(forward1)로그인아이디=" + id + "</h1>");
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목");
		dto.setContents("내용");
		request.setAttribute("board",dto);
		
		RequestDispatcher dis = request.getRequestDispatcher("forward2");
		dis.forward(request, response);
	}

}
