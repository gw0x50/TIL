package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list;

		if (page == null || page.equals("")) {
			list = dao.getBoardList();
		}
		else {
			int pageNum = Integer.parseInt(page);
			list = dao.getBoardList(pageNum, 5);
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter o = response.getWriter();
		String result = "";
		result += "<table border=3>";
		for (BoardDTO dto : list) {
			result += "<tr><td>" + dto.getSeq() + "</td><td><a href='detailboard?seq=" + dto.getSeq() + "'>" + dto.getTitle() + "</a></td><td>"
					+ dto.getWriter() + "</td><td>" + dto.getViewcount() + "</td></tr>";
		}
		result += "</table>";

		result += "<h1>페이지번호</h1>";
		int totalCnt = dao.getBoardCount();
		int pageCnt = totalCnt / 5;
		if (totalCnt % 5 != 0) pageCnt += 1;

		for (int i = 1; i <= pageCnt; i++) {
			result += "<a href='boardlist?page=" + i + "'>" + i + " </a>";
		}

		result += "<button id='write'>글쓰기</button>";
		result += "<script>document.getElementById('write').onclick = function(){" + "location.href='boardwrite.html'" + "}</script>";

		o.println(result);
	}

}
