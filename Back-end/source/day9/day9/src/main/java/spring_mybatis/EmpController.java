package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	@RequestMapping("/emplist")
	public ModelAndView getEmpList() {
		List<EmpVO> list =  service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist");
		
		return mv;
	}
	
	@RequestMapping("/empdetail")
	public ModelAndView getEmpDetail(int id) {
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		
		mv.addObject("empdetail", vo);
		mv.setViewName("/mybatis/empdetail");
		
		return mv;
	}
}
