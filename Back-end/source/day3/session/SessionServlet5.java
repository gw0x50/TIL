package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;

@WebServlet("/session5")
public class SessionServlet5 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			MemberDTO dto = new MemberDTO();
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("member") != null) {
				//session.removeAttribute("member");
				session.invalidate();
				
				/*session.setAttribute("member", xx)
				 * session.setAttribute("list", xx)
				 * 
				 * 세션 브라우저 종료 자동 삭제
				 * 또는
				 * 세션 브라우저 종료 이전 30분시간 액션 없다면 자동 삭제
				 * 세션 값 유지 시간 정한 곳 - 
				 * 1.Servers\..web.xml
				 *     <session-config>
        				<session-timeout>30</session-timeout>
    					</session-config>
				 * 2.프로젝트단위/webcontent\web-inf\web.xml
				 * 
				 * 
				 * */
			}
	
			response.setContentType("text/html;charset=utf-8");
			PrintWriter o = response.getWriter();
			o.println("세션정보확인=" + dto + "<br>");
			
			
		
	}

}
