package test.my.mvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class BoardMybatisDAO {
	@Autowired
	SqlSession session;
	
	public List<BoardDTO> getBoardList() {
		return session.selectList("board.getBoardList");
	}
	
	public BoardDTO getBoardDetail(int seq) {
		return session.selectOne("board.getBoardDetail", seq);
	}
	
	public void updateBoardViewcount(int seq) {
		session.update("board.updateBoardViewcount", seq);
	}
	
	public void insertBoard(BoardDTO dto) {
		session.insert("board.insertBoard", dto);
	}
}
