package melon.multi.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	@RequestMapping("/crud/start")
	public void start() {

	}

	@RequestMapping("/crud/list")
	public ModelAndView list() {
		String[] title = { "게시물1", "게시물2", "게시물3" };
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", title);
		mv.setViewName("/crud/list");
		return mv;
	}

	@RequestMapping(value = "/crud/add", method = RequestMethod.GET)
	public String addForm() {
		return "/crud/addform";
	}

	@RequestMapping(value = "/crud/add", method = RequestMethod.POST)
	public ModelAndView addResult(String title, String contents, String writer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title + ":" + contents + ":" + writer);
		mv.addObject("status", "게시물 1개 저장 완료");
		//mv.setViewName("/crud/add");
		return mv;
	}

	@RequestMapping(value = "/crud/update", method = RequestMethod.GET)
	public ModelAndView updateForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "선택한 게시글 제목");
		mv.addObject("contents", "선택한 게시물 제목");
		mv.addObject("writer", "작성자");
		mv.setViewName("/crud/updateform");
		return mv;
	}

	@RequestMapping(value = "/crud/update", method = RequestMethod.POST)
	public ModelAndView updateResult(String title, String contents, String writer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", title + ":" + contents + ":" + writer);
		mv.addObject("status", "게시물 1개 수정 완료");
		//mv.setViewName("/crud/update");
		return mv;
	}

	@RequestMapping("/crud/delete")
	public String delete(@RequestParam(value = "seq", required = false, defaultValue = "1") int seq) {
		System.out.println(seq + "번의 글 삭제.");
		return "redirect:/crud/list"; //url 매핑을 호출
	}
}
