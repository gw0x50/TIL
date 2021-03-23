package template;

import java.util.Scanner;

public class InsertProcess {
	void process() {
		Scanner key = new Scanner(System.in);
		System.out.println("사번 입력 : ");
		int id = key.nextInt();
		System.out.println("이름 입력 : ");
		String name = key.next();
		System.out.println("급여 입력 : ");
		double salary = key.nextDouble();

		Controller c = Controller.getInstance();
		c.insert(id, name, salary);
	}
}
