package servletTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GugudanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");

		String dan = request.getParameter("dan");
		int outputdan = 0;
		if (dan == null || dan == "") {
			outputdan = 2;
		}
		else {
			int dan2 = Integer.parseInt(dan);
			if (dan2 >= 2 && dan2 <= 9) {
				outputdan = dan2;
			}
			else {
				outputdan = 10;
			}
		}
		String format ="";
		format += "<h1>구구단</h1>";
		format += "<form action='gugu' method='post'>";
		format += " 단 : <input type='text' name='dan'> <input type='submit' value='구구단출력'>";
		format += "</form>";
		
		format += "<table border=3>";
		if (outputdan != 10) {
			for (int i = 1; i <= 9; i++) {
				format += "<tr><td>" + outputdan + " * " + i + " = " + (outputdan * i) + "</tr></td>";
			}
		}
		else {
			for (int i = 1; i <= 9; i++) {
				format += "<tr>";
				for (int j = 2; j <= 9; j++) {
					format += "<td>" + j + " * " + i + " = " + (i * j) + "</td>";
				}
				format += "</tr>";
			}
		}
		format += "</table>";

		format += "<a href='gugudan.html'>구구단 입력</a>";

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(format);
	}
}
