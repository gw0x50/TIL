package day5;

class Employee {
	int id, basePay, overPay, salary;
	String name;

	Employee(int id, String name, int basePay, int overPay) {
		this.id = id;
		this.name = name;
		this.basePay = basePay;
		this.overPay = overPay;
	}

	void payCal() {
		salary = basePay + overPay;
	}
}

class Manager extends Employee {
	int managerPay;

	Manager(int id, String name, int basePay, int overPay, int managerPay) {
		super(id, name, basePay, overPay);
		this.managerPay = managerPay;
	}

	void payCal() {
		salary = basePay + overPay + managerPay;
	}
}

class Engineer extends Employee {
	int qualiPay, techPay;

	Engineer(int id, String name, int basePay, int overPay, int qualiPay, int techPay) {
		super(id, name, basePay, overPay);
		this.qualiPay = qualiPay;
		this.techPay = techPay;
	}

	void payCal() {
		salary = basePay + overPay + qualiPay + techPay;
	}

}

class Secretary extends Employee {
	int secrePay;

	Secretary(int id, String name, int basePay, int overPay, int secrePay) {
		super(id, name, basePay, overPay);
		this.secrePay = secrePay;
	}

	void payCal() {
		salary = basePay + overPay + secrePay;
	}
}

public class SalaryTest {

	public static void main(String[] args) {
		Employee e[] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee(1000, "이사원", 10000, 5000);
		e[1] = new Manager(2000, "김간부", 20000, 10000, 10000);
		e[2] = new Engineer(3000, "박기술", 15000, 7500, 5000, 5000);
		e[3] = new Secretary(4000, "최비서", 15000, 7000, 10000);

		for (int i = 0; i < e.length; i++) {
			e[i].payCal();
			System.out.println(e[i].id + ":" + e[i].name + ":" + e[i].basePay + ":" + e[i].salary);
			if (e[i] instanceof Engineer) {
				System.out.println(((Engineer)e[i]).qualiPay+":"+((Engineer)e[i]).techPay);
			}
		}

	}

}
