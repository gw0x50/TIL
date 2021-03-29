package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSelectTest2 {
	// 1. 오라클 자동 시작 2.ojdbc6.jar 설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:xe", "hr", "hr");
			System.out.println("db연결성공");

			String sql = "SELECT r, first_name, salary FROM (SELECT rownum r, first_name, salary FROM (SELECT * FROM employees ORDER BY salary DESC)) WHERE r >= ? and r <= ?";

			// sql 저장 - 문법검사 - 실행 준비 상태
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));

			// 실행
			rs = st.executeQuery();

			// 리턴결과 검색
			while (rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				System.out.println(r + "|" + emp_name + "|" + salary);
			}

			System.out.println("db연결해제성공");
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
	}

}
