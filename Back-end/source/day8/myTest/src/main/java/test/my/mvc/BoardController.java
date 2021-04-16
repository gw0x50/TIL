package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;

	@RequestMapping("/boardlist")
	public ModelAndView getBoardList() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = service.getBoardList();

		mv.addObject("boardlist", list);
		mv.setViewName("/board/boardlist");

		return mv;
	}

	@RequestMapping("/boarddetail")
	public ModelAndView getBoardDetail(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = service.getBoardDetail(seq);
		service.updateBoardViewcount(seq);

		mv.addObject("boarddetail", dto);
		mv.setViewName("/board/boarddetail");

		return mv;
	}

	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	public String insertBoardView() {
		return "/board/boardinsert";
	}

	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	public String insertBoard(String title, String contents, String writer, int password) {		
		BoardDTO dto = new BoardDTO(-1, title, contents, writer, null, password, 0);
	
		service.insertBoard(dto);

		return "redirect:/boardlist";
	}

	@RequestMapping("/boardupdate")
	public ModelAndView updateBoard() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = service.getBoardList();

		mv.addObject("boardlist", list);
		mv.setViewName("/board/boardlist");

		return mv;
	}

	@RequestMapping("/boarddelete")
	public ModelAndView deleteBoard() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = service.getBoardList();

		mv.addObject("boardlist", list);
		mv.setViewName("/board/boardlist");

		return mv;
	}
}
