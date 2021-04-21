package multi.melonbottle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import multi.melonbottle.service.MemberService;
import multi.melonbottle.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String password, HttpServletRequest request) throws IOException {
		MemberVO vo = service.loginMember(id, password);

		HttpSession session = request.getSession();
		session.setAttribute("id", vo.getId());
		session.setAttribute("name", vo.getName());
		session.setAttribute("address", vo.getAddress());
		session.setAttribute("lv", vo.getLv());

		return "redirect:/";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST, produces = "applcation/json; charset=UTF-8")
	@ResponseBody
	public String loginCheck(String id, String password) throws IOException {
		MemberVO vo = service.loginMember(id, password);
		String result = "";

		if (vo != null) { //null이 아니라는 것은 넘겨받은 id, password를 가진 계정이 있다는 뜻
			result = "{\"check\":\"1\"}";
		}
		else {
			result = "{\"check\":\"0\"}";
		}

		return result;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerView() {
		return "member/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String register(HttpServletRequest request, MemberVO vo) throws IOException {
		vo.setLv(0); // lv = 0 : 일반 유저, lv = 1 : 관리자
		
		service.registerMember(vo);
		
		HttpSession session = request.getSession(); //회원 가입 후 자동 로그인 처리
		session.setAttribute("id", vo.getId());
		session.setAttribute("name", vo.getName());
		session.setAttribute("address", vo.getAddress());
		session.setAttribute("lv", vo.getLv());

		return "<script>alert('회원가입이 완료되었습니다.');location.href='/'</script>";
	}

	@RequestMapping(value = "/validCheck", method = RequestMethod.POST, produces = "applcation/json; charset=UTF-8")
	@ResponseBody
	public String memberValid(String id) {//폼 입력 데이터 전송
		String result = "";
		if (service.checkMember(id) == 0) { //0 일 경우 중복 ID가 없다는 뜻.
			result = "{\"check\":\"1\"}";
		}
		else {
			result = "{\"check\":\"0\"}";
		}
		return result;//json 문자열 형태 결과 값

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		MemberVO vo = service.selectMember((String)session.getAttribute("id")); //세션에 있는 id 정보를 받아 데이터 조회
		
		mv.addObject("vo", vo);
		mv.setViewName("/member/update"); //이후 update.jsp의 input 태그에 유저 정보를 미리 넣어줌
		
		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request, MemberVO vo) throws IOException {
		vo.setLv(0);
		service.updateMember(vo);
		HttpSession session = request.getSession();
		session.invalidate(); //기존 세션 초기화
		
		session = request.getSession(); //세션 새로 받아서 데이터 입력
		session.setAttribute("id", vo.getId());
		session.setAttribute("name", vo.getName());
		session.setAttribute("address", vo.getAddress());
		session.setAttribute("lv", vo.getLv());

		return "<script>alert('회원 정보를 수정했습니다.');location.href='/'</script>";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest request, String id) throws IOException {
		service.deleteMember(id);
		
		HttpSession session = request.getSession();
		session.invalidate();

		return "<script>alert('회원 탈퇴 처리되었습니다.');location.href='/'</script>";
	}
}
