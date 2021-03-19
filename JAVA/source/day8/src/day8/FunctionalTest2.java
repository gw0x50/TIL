package day8;

@FunctionalInterface
interface Math2 {
	public int calc(int first, int second);
}

@FunctionalInterface
interface D {
	int ma();
}

@FunctionalInterface
interface E {
	int mb(int i);
}

@FunctionalInterface
interface F {
	public int calc(int first, int second);
}

class C1 {

	static int mc1(int i, int j) {
		return i / j;
	}

	int mc2(int i, int j) {
		return i % j;
	}
}

public class FunctionalTest2 {
	String name = "멤버 변수";

	public static void main(String[] args) {
		String name = "지역 변수";

		C1.mc1(10, 2);
		C1 c = new C1();
		c.mc2(10, 2);
		/*
		 * Math2 m1 = (a, b) -> a * b;
		 * System.out.println(m1.calc(10, 2));
		 * Math2 m2 = (a, b) -> a - b;
		 * System.out.println(m2.calc(10, 2));
		 * Math2 m3 = (a, b) -> a + b;
		 * System.out.println(m3.calc(10, 2));
		 * Math2 m4 = (a, b) -> a / b;
		 * System.out.println(m4.calc(10, 2));
		 */
		// Math2 m5 = (i, j) -> C1.mc1(i, j);
		Math2 m5 = C1::mc1;
		System.out.println(m5.calc(10, 2));

		Math m6 = new C1()::mc2;
		System.out.println(m6.calc(10, 2));

		D d1 = () -> 1;
		System.out.println(d1.ma());

		E e1 = (a) -> {
			String name2 = "람다";
			System.out.println("람다식 실행");
			System.out.println(name);
			System.out.println(new FunctionalTest2().name);
			return a * a;
		};
		System.out.println(e1.mb(10));
	}
}
