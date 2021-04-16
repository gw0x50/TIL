package test.my.mvc;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BoardService {
	public List<BoardDTO> getBoardList();

	public BoardDTO getBoardDetail(int seq);

	public void updateBoardViewcount(int seq);
	
	public void insertBoard(BoardDTO dto);
}
