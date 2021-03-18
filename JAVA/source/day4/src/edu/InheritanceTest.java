package edu;

class Employee {
	int id;
	String name;
	String salary;
	String pw = "Employee";

	public void printEmp() {
		System.out.println(id + ":" + name + ":" + salary);
	}
}

class Manager extends Employee {
	String jobOfManage;
	int cntOfSub;
	String pw = "Manager";

	void test() {
		String pw = "test method";
		System.out.println(pw);
		System.out.println(this.pw);
		System.out.println(super.pw);
	}
	
	@Override
	public void printEmp() {
		super.printEmp();
		//System.out.println(id + ":" + name + ":" + salary);
		System.out.println(jobOfManage + ":" + cntOfSub);
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.id = 12345;
		m.name = "김부장";
		m.jobOfManage = "IT 직종관리";
		m.cntOfSub = 10;
		System.out.println(m.id + ":" + m.name + ":" + m.jobOfManage + ":" + m.cntOfSub);

		m.test();
		m.printEmp();
	}

}


