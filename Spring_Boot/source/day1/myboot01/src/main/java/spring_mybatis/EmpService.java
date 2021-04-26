package spring_mybatis;

import java.util.List;

public interface EmpService {
	public EmpVO getOneEmp(int employee_id);

	public List<EmpVO> getAllEmp();
	
	public List<EmpVO> getPagingEmp(int[] rownum);
	
	public void registerEmp(EmpVO vo);

//	public void insertEmp(EmpVO vo);
//
//	public void updateEmp(EmpVO vo);
//
//	public void deleteEmp(int employee_id);
//
//	public List<EmpVO> getPageEmp(int[] nums);
//
//	public void insertEmp2(EmpVO vo);
//	
//	public List<EmpVO> getEmpDept(List<Integer> deptlist);
//	
//	public void updateEmpMap(Map<String, String> map);

}
