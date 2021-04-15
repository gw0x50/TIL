package melon.multi.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	//1. 로그인 폼 출력
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginform() {
		return "loginform";
	}

	//2. 입력 내용 로그인 처리 결과 출력
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginresult(@ModelAttribute("vo") LoginVO vo) {
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");
		ModelAndView mv = new ModelAndView();
		System.out.println(vo.getId() + ":" + vo.getPw());
		if (vo.getId().equals("spring") && vo.getPw().equals("work")) {
			mv.addObject("result", "정상 로그인 사용자");
		}
		else {
			mv.addObject("result", "아이디 암호를 다시 입력하세요.");
		}

		mv.setViewName("loginresult");
		return mv;
	}
}
