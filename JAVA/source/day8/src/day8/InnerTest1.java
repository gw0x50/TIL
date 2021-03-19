package day8;

import day8.Outer2.Inner2;

class Outer2 {
	int outervar = 10;
	static int outervar2 = 20;
	String name = "Outer2";

	class Inner { // non-static 멤버 중첩 클래스
		String name = "Inner";

		void m() {
			String name = "m Method";
			System.out.println("Inner 메소드 실행.");
			System.out.println(outervar);
			System.out.println(outervar2);
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Outer2.this.name);
		}
	}

	static class Inner2 { // static 멤버 중첩 클래스
		void m2() {
			System.out.println("Inner 메소드 실행2.");
			//System.out.println(outervar);
			System.out.println(outervar2);
		}
	}

	void test() {
		class Inner3 {
			void m3() {
				System.out.println("Inner 메소드 실행3.");
			}
		}
		new Inner3().m3();
	}
}

public class InnerTest1 {

	public static void main(String[] args) {
		//Outer o = new Outer();
		Outer2.Inner i = new Outer2().new Inner();
		i.m();

		Inner2 i2 = new Outer2.Inner2();
		//i2.m2();

		Outer2 o = new Outer2();
		o.test();

	}

}
