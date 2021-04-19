package ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAjaxController {

	@RequestMapping(value = "/ajax/login", method = RequestMethod.GET)
	public String loginform() {//폼 출력  http요청
		return "/ajax/loginajax";//뷰이름
	}

	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST, produces = { "applcation/json;charset=utf-8" })
	@ResponseBody
	public String loginresult(String id, String pw) {//폼 입력 데이터 전송  ajax요청
		System.out.println(id + ":" + pw);
		String result = null;
		if (id.equals("spring") && pw.equals("spring")) {
			result = "{\"process\":\"정상로그인\" , \"role\":\"admin\"}";
		}
		else {
			result = "{\"process\":\"비정상로그인\" , \"role\":\"user\"}";
		}
		return result;//json문자열형태결과값

	}
	
//	@RequestMapping("/ajax/board")
//	@ResponseBody
//	public BoardDTO getBoardDTO(int seq) {
//		BoardDTO dto = new BoardDTO();
//		dto.setSeq(seq);
//		dto.setTitle("게시물제목");
//		dto.setContents("게시물내용");
//		dto.setWriter("게시물작성자");
//		dto.setViewcount(100);
//		
//		return dto;
//	}
	
	@RequestMapping("/ajax/board/{seq}")
	@ResponseBody
	public BoardDTO getBoardDTO(@PathVariable("seq") int seq) {
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle("게시물제목");
		dto.setContents("게시물내용");
		dto.setWriter("게시물작성자");
		dto.setViewcount(100);
		
		return dto;
	}
	
	@RequestMapping("/ajax/boardlist")
	@ResponseBody
	public ArrayList<BoardDTO> getBoardListDTO() {
		BoardDTO dto = new BoardDTO();
		dto.setSeq(1);
		dto.setTitle("게시물제목");
		dto.setContents("게시물내용");
		dto.setWriter("게시물작성자");
		dto.setViewcount(100);
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		list.add(dto);
		
		return list;
	}
}
