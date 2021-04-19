package ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Ajax 요청 처리 전용 컨트롤러
@RestController
public class AllAjaxController {
	
	//@RequestMapping("/a")
	//public EmpVO a() {
	//	return new EmpVO();
	//}
	
	@RequestMapping("/b")
	public String b() {
		return "{}";
	}
	
	@RequestMapping("/c")
	public int c() {
		return 0;
	}
}
