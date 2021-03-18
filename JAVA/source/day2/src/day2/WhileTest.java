package day2;

public class WhileTest {

	public static void main(String[] args) {
		int number = (int) (Math.random() * 50) + 1;

		while (true) {
			System.out.println(number);
			number = (int) (Math.random() * 50) + 1;
			if (number == 25)
				break;
		}
		System.out.println(number);
	}

}
