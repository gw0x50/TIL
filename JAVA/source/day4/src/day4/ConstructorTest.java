package day4;

class Employee {
	Employee() {
		//id = "---";
		//name = "none";
		this("===","none");
	}

	Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	Employee(String id) {
		//this.id = id;
		//name = "none";
		this(id,"none");
	}

	String id;
	String name;
	String title;
	String dept;

	// 메소드
	String work() {
		System.out.println(name + " 사원이 " + dept + " 부서에서 일한다.");
		return "이달의 급여처리 업무 완료";
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		Employee e1 = new Employee("100", "이사원");// 생성자 호출
		Employee e2 = new Employee("200");// 생성자 호출
		Employee e3 = new Employee();// 생성자 호출

		System.out.println(e1.id + ":" + e1.name);
		System.out.println(e2.id + ":" + e2.name);
		System.out.println(e3.id + ":" + e3.name);

		e1.work();
		e2.work();
		e3.work();
	}

}
