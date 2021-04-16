package mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws IOException {
		//db 연결 xml
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/db-config.xml"));
		SqlSession session = factory.openSession(true);
		//System.out.println(session.getConnection());

		EmpService service = new EmpServiceImpl();
		EmpDAO dao = new EmpDAO();

		dao.setSession(session);
		((EmpServiceImpl) service).setDao(dao);

		//EmpVO vo1 = dao.getOneEmp(100);	
		//System.out.println(vo1);

		/*
		List<EmpVO> list = service.getAllEmp();
		for(EmpVO vo : list) {
			System.out.println(vo);
		}
		*/

		/*
		EmpVO vo2 = new EmpVO(300, "사원", "김", "kim@a.com", "01022223333", "IT_PROG", 300, 100, 50);
		service.insertEmp(vo2);
		System.out.println("1명 사원 저장 완료");
		*/

		/*
		EmpVO vo3 = new EmpVO();
		vo3.setEmployee_id(300);
		vo3.setFirst_name("대리");
		service.updateEmp(vo3);
		System.out.println("1명 사원 수정 완료");
		*/

		/*
		service.deleteEmp(300);
		System.out.println("1명 사원 삭제 완료");
		*/

		/*
		int[] nums = {11, 20};
		List<EmpVO> list = service.getPageEmp(nums);
		for(EmpVO vo : list) {
			System.out.println(vo);
		}
		*/

		/*
		EmpVO vo = new EmpVO();
		//vo.setEmployee_id(2000);
		vo.setFirst_name("과장");
		vo.setLast_name("김");//not null
		vo.setJob_id("IT_PROG");//jobs테이블 참조
		vo.setDepartment_id(100);//departments테이블 참조
		vo.setEmail("kim3@kitri.com");//unique
		vo.setPhone_number("010222222");
		vo.setSalary(1000);
		service.insertEmp2(vo);
		System.out.println("===insert seq 완료===");
		*/
		
		/*
		List<Integer> deptList = new ArrayList<Integer>();
		deptList.add(10);
		deptList.add(50);
		deptList.add(80);
		deptList.add(100);
		List<EmpVO> list = service.getEmpDept(deptList);
		for (EmpVO vo : list) {
			System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name() + ":" + vo.getDepartment_id());
		}
		*/
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("dept","50");
		map.put("email","a2@b.com");
		map.put("id", "0");
		
		service.updateEmpMap(map);
		System.out.println("업데이트 수행 완료");
	}
}
