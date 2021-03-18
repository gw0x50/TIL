package day7;

import java.util.ArrayList;

class Employee {
	int id;
	String name;
	double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return id + " - " + name + " - " + salary;
	}

}

public class ArrayListTest {

	public static void main(String[] args) {

		//ArrayList = 여러 타입 데이터 저장 가능
		//동일타입 데이터만 저장하되 갯수 변경 의
		// 1> 컴파일러 컴파일시점 타입 체크
		// 2> 형변환 필요 없음
		// 3> 타입 정적 유지
		// 4> 타입 지정 x -> add(Object o> / Object <- get(0)
		// 5> 타입 지정 o -> add(? o) / ? <- get(0)
		// 6> genenic ArrayList
		/*
		ArrayList list = new ArrayList(5);
		list.add(100);
		list.add(new Integer(200));
		list.add(2.55);
		list.add(new Double(32.14));
		list.add(300);
		list.add(9.99);
		list.add("자바 프로그램"); // 6번 인덱스
		list.add(0, "변경"); // 0번 인덱스에 변경 저장,
		list.set(0, "변경확인"); // 0번 인덱스 저장 데이터를 "변경확인" 수정
		list.remove(0);
		*/
		
		ArrayList<Employee> list = new ArrayList<Employee>(5);
		
		Employee e1 = new Employee(100, "이사원", 56000.55);
		Employee e2 = new Employee(200, "최대리", 66000.55);
		Employee e3 = new Employee(300, "박과장", 76000.55);
		list.add(e1);
		list.add(e2);
		list.add(e3);

		System.out.println(list.size());

		// list 내에 멀티캠퍼스 문자열 삭제
		if (list.contains("멀티캠퍼스")) {
			System.out.println(list.indexOf("멀티캠퍼스"));
			list.remove("멀티캠퍼스");
		}

		for (int i = 0; i < list.size(); i++) {
			/*
			Object o = list.get(i);
			System.out.println(i + " 번 인덱스 = " + list.get(i));
			if (o instanceof Employee) {
				System.out.println(((Employee) o).name);

			}
			*/
			Employee o =list.get(i);
			System.out.println(i + " 번 인덱스 = " + list.get(i));
			System.out.println(o.name);
		}

		//autoboxing, unboxing
		int i = new Integer(500);
		Integer in = 100;
	}

}
