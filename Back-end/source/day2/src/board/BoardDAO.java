package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	void insertBoard(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");

			String insertSQL = "INSERT INTO board VALUES(board_seq.nextval, ?, ?, ?, sysdate, ?, 0)";

			pt = con.prepareStatement(insertSQL);
			pt.setString(1, dto.getTitle());
			pt.setString(2, dto.getContents());
			pt.setString(3, dto.getWriter());
			pt.setInt(4, dto.getPassword());

			pt.executeUpdate();

		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public ArrayList<BoardDTO> getBoardList() {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

			String selectSQL = "SELECT * FROM board ORDER BY seq DESC";

			pt = con.prepareStatement(selectSQL);

			rs = pt.executeQuery();

			while (rs.next()) {
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				int password = rs.getInt("password");
				int viewcount = rs.getInt("viewcount");

				BoardDTO dto = new BoardDTO();
				dto.setSeq(seq);
				dto.setTitle(title);
				dto.setContents(contents);
				dto.setWriter(writer);
				dto.setTime(time);
				dto.setPassword(password);
				dto.setViewcount(viewcount);

				list.add(dto);
			}
			return list;

		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	public ArrayList<BoardDTO> getBoardList(int pageNum, int cntPerPage) {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

			String selectSQL = "SELECT * FROM (SELECT a.*, ROWNUM as rnum FROM (SELECT * FROM board ORDER BY seq DESC)a) WHERE rnum BETWEEN ? AND ?";

			int startPage = ((pageNum - 1) * cntPerPage) + 1;
			int endPage = (pageNum * cntPerPage);

			pt = con.prepareStatement(selectSQL);
			pt.setInt(1, startPage);
			pt.setInt(2, endPage);

			rs = pt.executeQuery();

			while (rs.next()) {
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("writer");
				String time = rs.getString("time");
				int password = rs.getInt("password");
				int viewcount = rs.getInt("viewcount");

				BoardDTO dto = new BoardDTO();
				dto.setSeq(seq);
				dto.setTitle(title);
				dto.setContents(contents);
				dto.setWriter(writer);
				dto.setTime(time);
				dto.setPassword(password);
				dto.setViewcount(viewcount);

				list.add(dto);
			}
			return list;

		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public int getBoardCount() {
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		int cnt = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");

			String selectSQL = "SELECT COUNT(*) FROM board";

			pt = con.prepareStatement(selectSQL);

			rs = pt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("count(*)");

			}
			return cnt;

		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return cnt;
	}

	public BoardDTO getDetailBoard(int seq) {
		BoardDTO dto = new BoardDTO();

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");

			String updateSQL = "UPDATE board SET viewcount = viewcount+1 WHERE seq=?";
			String selectSQL = "SELECT * FROM board WHERE seq=?";

			pt = con.prepareStatement(updateSQL);
			pt.setInt(1, seq);
			pt.executeUpdate();

			pt = con.prepareStatement(selectSQL);
			pt.setInt(1, seq);
			rs = pt.executeQuery();

			rs.next();
			dto.setSeq(rs.getInt("seq"));
			dto.setTitle(rs.getString("title"));
			dto.setContents(rs.getString("contents"));
			dto.setWriter(rs.getString("writer"));
			dto.setTime(rs.getString("time"));
			dto.setPassword(rs.getInt("password"));
			dto.setViewcount(rs.getInt("viewcount"));

			return dto;
		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return dto;
	}

	public boolean getMember(String writer) {

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@61.98.63.15:1521:xe", "jdbc", "jdbc");

			String selectSQL = "SELECT id FROM member WHERE id=?";

			pt = con.prepareStatement(selectSQL);
			pt.setString(1, writer);
			rs = pt.executeQuery();

			if (rs.next()) check = true;

		}
		catch (ClassNotFoundException e) {
			System.out.println("check driver.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pt.close();
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return check;
	}
}
