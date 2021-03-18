package day3;

class Employee { //회사원 객체 클래스
	// 사번 이름 직급 부서 변수 = 회사원 정보 상태
	String id;
	String name;
	String title;
	String dept;

	// 메소드
	String work() {
		System.out.println(name + " 사원이 " + dept + " 부서에서 일한다.");
		return "이달의 급여처리 업무 완료";
	}
}

public class EmployeeTest {

	public static void main(String[] args) {
		// 실행 문장 main 작성
		Employee e1 = new Employee();
		e1.id = "100";
		e1.name = "박대리";
		e1.title = "대리";
		e1.dept = "인사부";
		System.out.println(e1.id + ":" + e1.name + ":" + e1.title + ":" + e1.dept + ":");
		System.out.println(e1.work());
		
		
		Employee e2 = new Employee();
		e2.id = "200";
		e2.name = "최사원";
		e2.title = "신입사원";
		e2.dept = "IT 개발부";
		System.out.println(e2.id + ":" + e2.name + ":" + e2.title + ":" + e2.dept + ":");
		System.out.println(e2.work());
	}

}
/* 클래스 1개 + 여러 개 = 1개 파일 public 선언
 * 클래스명.java main 메소드 가진 클래스명.java */
