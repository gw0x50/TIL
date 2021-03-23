package template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateProcess {
	void process() {

		Scanner key = new Scanner(System.in);
		System.out.println("사원정보수정을 선택하셨습니다.");
		// 수정 사번 입력 : 200
		// 수정항목 입력 : "name 박수정" -> 이름 박수정으로 변경
		/*
		 * employee.txt 파일에서 1라인씩 읽어서
		 * '|' 분리 첫번째 요소(=사번)이 200 인 라인을 찾아서
		 * '|' 분리 두번째 요소(=이름을) 박수정으로 변경
		 * 모든 라인을 다시 employee.txt로 다시 저장
		 * 100|이자바|10000.0
		 * 200|박자바|30000.0
		 * 300|김사원|20000.0
		 * FileWriter fw = new FileWriter("src/day9/employee.txt");
		 */
		System.out.println("수정 사번 입력 : ");
		String inputId = key.next();// 200
		System.out.println("수정 항목 입력 : ");// name 박수정
		key.next(); // name or salary
		String inputName = key.next();

		Controller c = Controller.getInstance();
		c.update(inputId, inputName);
	}
}
