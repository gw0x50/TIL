package template;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {
		Scanner k ey = new Scanner(System.in);

		while (true) {
			System.out.println("===다음과 같은 메뉴 이용 가능합니다===\n" + "1.사원등록\n" + "2.사원정보조회\n" + "3.사원정보수정\n" + "4.사원탈퇴\n"
					+ "5.프로그램종료\n" + "\n" + "번호입력 : ");
			int menu = key.nextInt();
			if (menu == 1) {
				InsertProcess p = new InsertProcess();
				p.process();
			}
			else if (menu == 2) {
				ViewProcess v = new ViewProcess();
				ArrayList<EmployeeVO> list = v.process();
				for (EmployeeVO vo : list) System.out.println(vo);
			}
			else if (menu == 3) {
				UpdateProcess u = new UpdateProcess();
				u.process();
			}
			else if (menu == 4) {
				System.out.println("사원탈퇴를 선택하셨습니다.");
				// 퇴사한 사번 입력 : 100
				// 100 사번 list에서 삭제
			}
			else if (menu == 5) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			else {
				System.out.println("해당 기능의 메뉴는 존재하지 않습니다");
			}
		}
	}

}
