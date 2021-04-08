package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detailboard")
public class DetailBoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetailBoard(seq);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter o = response.getWriter();
		String result = "";
		
		result += "<table border=3>";
		result += "<tr><td>번호</td><td>" + dto.getSeq() + "</td></tr>";
		result += "<tr><td>제목</td><td>" + dto.getTitle() + "</td></tr>";
		result += "<tr><td>내용</td><td>" + dto.getContents() + "</td></tr>";
		result += "<tr><td>작성자</td><td>" + dto.getWriter() + "</td></tr>";
		result += "<tr><td>암호</td><td>" + dto.getPassword() + "</td></tr>";
		result += "<tr><td>조회수</td><td>" + dto.getViewcount() + "</td></tr>";
		result += "</table>";
		
		o.println(result);
		
	}
}
