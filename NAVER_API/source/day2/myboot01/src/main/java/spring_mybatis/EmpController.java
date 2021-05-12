package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;

	@RequestMapping("/emplist")
	public ModelAndView getEmpList() {
		List<EmpVO> list = service.getAllEmp();
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

	@RequestMapping("/emplistpage")
	public ModelAndView getEmpList(int page) {

		ModelAndView mv = new ModelAndView();

		int[] rownum = new int[2];
		rownum[0] = (page - 1) * 10 + 1;
		rownum[1] = page * 10;
		
		List<EmpVO> list = service.getPagingEmp(rownum);
		
		mv.addObject("emplist", list);
		mv.setViewName("/mybatis/emplist");

		return mv;
	}
	
	@RequestMapping(value="/empadd", method = RequestMethod.GET)
	public String addEmp() {
		return "/mybatis/addform";
	}
	
	@RequestMapping(value="/empadd", method = RequestMethod.POST)
	public String addEmp2(EmpVO vo) {
		service.registerEmp(vo);
		return "redirect:/emplist";
	}
	
	@RequestMapping(value="/empmodify", method = RequestMethod.GET)
	public ModelAndView modifyEmp(int id) {
		ModelAndView mv = new ModelAndView();
		EmpVO vo = service.getOneEmp(id);
		mv.addObject("emp", vo);
		mv.setViewName("/mybatis/modifyform");
		
		return mv;
	}
}
