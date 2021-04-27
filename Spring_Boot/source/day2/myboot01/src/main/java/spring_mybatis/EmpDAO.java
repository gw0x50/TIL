package spring_mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("dao")
public interface EmpDAO {
	
	public EmpVO getOneEmp(int employee_id);
	
	public List<EmpVO> getAllEmp();
	
	public List<EmpVO> getPagingEmp(int[] rownum);
	
	public void registerEmp(EmpVO vo);
	
	public EmpVO checkEmp(EmpVO vo);
	
	public String checkJob(EmpVO vo);
	
	public void insertEmp(EmpVO vo);
	
//	public void insertEmp(EmpVO vo) {
//		session.insert("kdigital.insertEmp", vo);
//	}
//
//	public void updateEmp(EmpVO vo) {
//		session.update("kdigital.updateEmp", vo);
//	}
//
//	public void deleteEmp(int employee_id) {
//		session.delete("kdigital.deleteEmp", employee_id);
//	}
//
//	public List<EmpVO> getPageEmp(int[] nums) {
//		return session.selectList("kdigital.pageEmp", nums);
//	}
//
//	public void insertEmp2(EmpVO vo) {
//		session.insert("kdigital.insertEmp", vo);
//	}
//	public List<EmpVO> getEmpDept(List<Integer> deptlist) {
//		return session.selectList("kdigital.selectWithList", deptlist);
//	}
//	public void updateEmpMap(Map<String, String> map) {
//		session.update("kdigital.updateEmpMap",map);
//	}
}
