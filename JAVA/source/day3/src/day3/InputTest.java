package day3;

public class InputTest {

	public static void main(String[] args) {
		main2();
		for (int i=0;i<args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println(args[0] + args[1]);
		
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		System.out.println(first + second);
		
	}

	public static void main2() {
		System.out.println("main2");
	}
}
