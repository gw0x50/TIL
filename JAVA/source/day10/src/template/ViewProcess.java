package template;

import java.util.ArrayList;

public class ViewProcess {
	ArrayList<EmployeeVO> process() {
		System.out.println("사원정보조회를 선택하셨습니다.");
		/*
		 * day9/employee.txt 파일 저장 employee 객체만큼 입력
		 * id+"|"+name+"|"+ salary의 1.5배 형식으로 콘솔 출력
		 */
		Controller c = Controller.getInstance();
		return c.getAll();
	}
}
