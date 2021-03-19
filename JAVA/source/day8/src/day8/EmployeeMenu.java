package day8;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	int id;
	String name = "";
	double salary;

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return id + " | " + name + " | " + salary;
	}

}

class EmployeeManager {
	public void employeeMenu() {
		System.out.print("\n===다음과 같은 메뉴 이용 가능합니다===\n"
				+ "1.사원등록\n"
				+ "2.사원정보조회\n"
				+ "3.사원정보수정\n"
				+ "4.사원탈퇴\n"
				+ "5.프로그램종료\n"
				+ "\n"
				+ "번호 입력 : ");
	}

	public Employee employeeInsert(Scanner sc) {
		System.out.println("사원정보 입력을 선택하셨습니다.");

		System.out.print("사번 입력 : ");
		int id = sc.nextInt();
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("급여 입력 : ");
		double salary = sc.nextDouble();

		System.out.println("사원 등록을 마쳤습니다.");

		return new Employee(id, name, salary);

	}

	public void employeeSelect(ArrayList<Employee> list) {
		System.out.println("사원정보 조회를 선택하셨습니다.");
		for (Employee a : list) {
			System.out.println(a);
		}
	}

	public void employeeUpdate(ArrayList<Employee> list, Scanner sc) {
		System.out.print("사원정보 수정을 선택하셨습니다.\n"
				+ "수정 사번 입력 : ");
		int id = sc.nextInt();
		
		System.out.println("수정 항목 입력 : ");
		String text = sc.nextLine();
		
	}

	public void employeeDelete() {
		System.out.println("사원정보 삭제를 선택하셨습니다.");
	}
}

public class EmployeeMenu {

	public static void main(String[] args) {
		EmployeeManager m = new EmployeeManager();
		ArrayList<Employee> list = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			m.employeeMenu();

			int num = sc.nextInt();
			if (num == 1) {
				list.add(m.employeeInsert(sc));
			} else if (num == 2) {
				m.employeeSelect(list);
			} else if (num == 3) {
				m.employeeUpdate(list, sc);
			} else if (num == 4) {
				m.employeeDelete();
			} else if (num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("해당 기능의 메뉴는 존재하지 않습니다.");
			}

		}
	}

}
