package multi.melonbottle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import multi.melonbottle.service.CenterService;
import multi.melonbottle.vo.CenterVO;

@Controller
@RequestMapping("/center")
public class CenterController {
	
	@Autowired
	private CenterService service;
	
	@RequestMapping("/list")
	public ModelAndView centerView() {
		ModelAndView mv = new ModelAndView();
		List<CenterVO> centerList = service.selectAllCenter();
		
		mv.addObject("centerList", centerList);
		mv.setViewName("/index");
		
		return mv;
		
	}
	
}
