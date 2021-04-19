package com.multi.kdigital2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "hello boot!");
		mv.setViewName("hello");

		return mv;
	}

}
