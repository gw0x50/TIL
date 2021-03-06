package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedInsertTest {
//1. 오라클 자동 시작 2.ojdbc6.jar  설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		Connection conn = null;
		try { 
			// jdbc driver 메모리  로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			//jdbc  계정 c_emp  테이블에 데이터 저장
			// 700 김자바 임원 10000 10  --> 명령행 매개변수로 입력
            //  자바  "sql" 정의 
			//( constraint c_emp_title_ck check(title in ('사원','대리','과장','부장','임원') 정의)
			/* c_emp 테이블 제약조건 설정 ?????
			select constraint_name, constraint_type, search_condition, table_name
    		from user_constraints
  			where LOWER(table_name)='c_emp'
			 * */
			
			String sql = "insert into c_emp values(?,?,?,?,?)";
			// 실행 sql 형태 잡은 상태. 문법검사마치고 준비상태
			PreparedStatement st = conn.prepareStatement(sql);
			//? 부분 값 세팅 = sql  문장 입력파라미터값 세팅
			st.setInt(1, 900);// 오라클 number 로 변경
			//st.setString(2, "김신입"); //오라클 varchar2 로 변경 ""-->''변경 
			st.setNString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 10);
			st.setNString(2, "김신입");
			//실행
			int insertrow = st.executeUpdate();
			//리턴결과 검색
			System.out.println(insertrow+"  개의 행 삽입");
			
			
			System.out.println("db연결해제성공");	
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 원인 출력
		}finally {
			try {
			conn.close();
			}catch(SQLException e) { }
		}
	}

}
