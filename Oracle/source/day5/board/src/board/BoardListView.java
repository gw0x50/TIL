package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardListView {
	void input() {
		Scanner sc = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		System.out.println("페이지 번호 입력 : ");
		int pageNum = sc.nextInt();
		System.out.println("페이지 크기 입력 : ");
		int cntPerPage = sc.nextInt();

		if (pageNum == 0 || cntPerPage == 0) list = dao.getBoardList();
		else if (pageNum > 0) list = dao.getBoardList(pageNum, cntPerPage);

		for (BoardDTO dto : list) System.out.println(dto.getSeq() + " | " + dto.getTitle() + " | " + dto.getContents() + " | "
				+ dto.getWriter() + " | " + dto.getTime() + " | " + dto.getPassword() + " | " + dto.getViewcount());
	}
}
