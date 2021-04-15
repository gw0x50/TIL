package emp;

public class EmpMain {

	public static void main(String[] args) {
		VO vo = new EmpVO();
		vo.setId(100);
		vo.setName("이사원");
		//(EmpVO)vo.setSalary(12300);
		
		VO vo2 = new MemberVO();
		vo2.setId(100);
		vo2.setName("김회원");
		//vo2.setEmail("m@a.com");
		
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(vo);
		dao.insertEmp(vo2);
		
		//주입, 의존성 주입
		System.out.println("회원 등록 마쳤습니다.");
	}

}
