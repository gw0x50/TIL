package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.mvc")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] path_spl = path.split("/");
		String result = path_spl[path_spl.length-1];
		System.out.println(result);
		
		//1. HelloController 호출
		HandlerMapping mapping = new HandlerMapping(); //hello.mvc
		Controller controller = mapping.getController("hello.mvc");
		String viewName = controller.handleRequest(request, response);
		
		//2. view 이동
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
		
	}

}
