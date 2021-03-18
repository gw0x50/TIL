package day4;

class A {
	private static A a1 = new A();

	private A() {
		System.out.println("A 생성자 호출");
	}

	static A getInstance() {
		return a1; // 객체 생성 이전 메모리 저장 유지
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		A.getInstance(); // A타입 객체 생성 통로 

	}

}
