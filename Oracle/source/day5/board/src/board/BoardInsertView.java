package board;

import java.util.Scanner;

public class BoardInsertView {
	BoardDTO input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("제목 입력 : ");
		String title = sc.nextLine();
		System.out.println("내용 입력 : ");
		String contents = sc.nextLine();
		System.out.println("작성자 입력 : ");
		String writer = sc.nextLine();
		System.out.println("글 암호 입력 : ");
		int password = sc.nextInt();
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setWriter(writer);
		dto.setPassword(password);
		
		return dto;
	}
}
