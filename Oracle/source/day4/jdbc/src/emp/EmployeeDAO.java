
package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.EmployeeDTO;

public class EmployeeDAO {
	// 1. 오라클 자동 시작 2.ojdbc6.jar 설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");

			String sql = "SELECT r, first_name, salary FROM (SELECT rownum r, first_name, salary FROM (SELECT * FROM employees ORDER BY salary DESC)) WHERE r >= ? and r <= ?";

			// sql 저장 - 문법검사 - 실행 준비 상태
			st = conn.prepareStatement(sql);
			
			int intCurrentPage = Integer.parseInt(currentPage);
			int intCntPerPage = Integer.parseInt(cntPerPage);
			
			st.setInt(1, (intCurrentPage * intCntPerPage) - intCntPerPage + 1);
			st.setInt(2, intCurrentPage * intCntPerPage);

			// 실행
			rs = st.executeQuery();
			ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

			// 리턴결과 ResultSet - ArrayList<EmployeeDTO> 복
			while (rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				
				list.add(dto);
				
				System.out.println(r + "|" + emp_name + "|" + salary);
			}

			System.out.println("db연결해제성공");
			return list;
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}
		catch (SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();// 자세한 원인 출력
		}
		finally {
			try {
				rs.close();
				st.close();
				conn.close();
			}
			catch (SQLException e) {
			}
		}
		return null;
	}

}

