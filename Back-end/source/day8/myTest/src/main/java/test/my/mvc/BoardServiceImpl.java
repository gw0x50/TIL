package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMybatisDAO dao;
	
	public void setDao(BoardMybatisDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardDTO getBoardDetail(int seq) {
		return dao.getBoardDetail(seq);
	}

	@Override
	public void updateBoardViewcount(int seq) {
		dao.updateBoardViewcount(seq);
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		dao.insertBoard(dto);
	}

}
