package day8;

class Outer {
	class Inner {
		void m() {
			System.out.println("Inner 메소드 실행.");
		}
	}

	class Inner2 {
		void m2() {
			System.out.println("Inner 메소드 실행2.");
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

public class InnerTest2 {

	public static void main(String[] args) {
		//Outer o = new Outer();
		Outer.Inner i = new Outer().new Inner();
		i.m();
		
		//Outer.Inner2 i2 = new Outer.Inner2();
		//i2.m2();
		
		Outer o = new Outer();
		o.test();
		
	}

}
