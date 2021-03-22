package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	int id;
	String name;
	double salary;

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// setter getter
	// toString
	public String toString() {
		return id + "|" + name + "|" + salary;
	}

}

public class MenuTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);

		Employee e = null;
		while (true) {
			System.out.println("===다음과 같은 메뉴 이용 가능합니다===\n" + "1.사원등록\n" + "2.사원정보조회\n" + "3.사원정보수정\n" + "4.사원탈퇴\n"
					+ "5.프로그램종료\n" + "\n" + "번호입력 : ");
			int menu = key.nextInt();
			if (menu == 1) {
				System.out.println("사번 입력 : ");
				int id = key.nextInt();
				System.out.println("이름 입력 : ");
				String name = key.next();
				System.out.println("급여 입력 : ");
				double salary = key.nextDouble();
				e = new Employee(id, name, salary);

				/*
				 * day9/employee.txt 파일에 e객체의 id, name, salary 3 변수 내용을 1줄에 출력
				 */
				try {
					FileWriter fw = new FileWriter("src/day9/employee.txt", true);
					fw.write(e.toString() + "\n"); // id+"|"+name+"|"+salary
					fw.close();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}

			}
			else if (menu == 2) {
				System.out.println("사원정보조회를 선택하셨습니다.");
				/*
				 * day9/employee.txt 파일 저장 employee 객체만큼 입력
				 * id+"|"+name+"|"+ salary의 1.5배 형식으로 콘솔 출력
				 */
				try {
					FileReader fr = new FileReader("src/day9/employee.txt");
					Scanner sc = new Scanner(fr);
					// id+"|"+name+"|"+salary
					while (sc.hasNextLine()) {
						String line = sc.nextLine();
						// line 의 내용을 분리(|)
						String items[] = line.split("\\|");

						String id = items[0];
						String name = items[1];
						double salary = Double.parseDouble(items[2]);// 급여
						System.out.println(id + "|" + name + "|" + salary * 1.5);

					}
					sc.close();
					fr.close();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}

			}
			else if (menu == 3) {
				System.out.println("사원정보수정을 선택하셨습니다.");
				System.out.print("수정 사번 입력 : ");
				String inputId = key.next();
				System.out.println("수정 항목 입력 : ");
				key.next();
				String inputName = key.next();

				try {
					FileReader fr = new FileReader("src/day9/employee.txt");
					Scanner sc = new Scanner(fr);

					ArrayList<String> list = new ArrayList<String>();

					while (sc.hasNextLine()) {
						String line = sc.nextLine(); // \n 이전 문자까지 입력
						String items[] = line.split("\\|");

						String id = items[0];
						String name = items[1];
						String salary = items[2];
						if (id.equals(inputId)) name = inputName;
						list.add(id + "|" + name + "|" + salary);
					}
					sc.close();
					fr.close();
					FileWriter fw = new FileWriter("src/day9/employee.txt");
					for (String one : list) fw.write(one + "\n");
					fw.close();

				}
				catch (IOException ex) {
					ex.printStackTrace();
				}

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
