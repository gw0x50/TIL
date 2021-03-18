package day3;

class Test {
	int ma() {
		int i = 10;
		return i * i;
	}

	String mb() {
		String s = "java";
		return s.toUpperCase();
	}

	int[] mc() {
		int[] i = new int[3];
		i[0] = 100;
		i[1] = 200;
		i[2] = 300;
		return i;
	}

	void md() {
		int i = 10;
		System.out.println(i * i);
	}

	void me() {
		int i = 0;
		System.out.println("me 메소드 시작");
		// if 조건 중단
		// 반복문 중단 - break;
		if (i == 0)
			return;
		System.out.println("me 메소드 종료");
	}
}

public class ReturnTypeTest {

	public static void main(String[] args) {

		Test t = new Test();

		int r1 = t.ma();
		System.out.println(r1);

		String r2 = t.mb();
		System.out.println(r2);

		int[] r3 = t.mc();
		for (int one : r3)
			System.out.println(one);

		t.md();
		t.me();
		
		System.out.println("main 종료");

	}

}
