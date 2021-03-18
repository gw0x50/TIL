package day4;

class Parent {
	int su1 = 10;

	void pr() {
		System.out.println(su1);
	}

	void mp() {
		System.out.println("Parent");
	}
}

class Child extends Parent {
	int su2 = 20;

	@Override
	void pr() {
		System.out.println(su2);
	}

	void mc() {
		System.out.println("Child");
	}
}

public class TypeCastingTest {

	public static void main(String[] args) {
		//Parent p1 = new Parent(); // 형변환 필요 X
		//Child c1 = new Child(); // 형변환 필요 X

		Parent p2 = new Child(); // 자동 형변환 가능
		System.out.println(p2.su1);
		//System.out.println(p2.su2);
		p2.mp();
		//p2.mc();
		p2.pr();
		
		Child c2 = null;
		System.out.println();
		if(p2 instanceof Child) {
			System.out.println("test1");
			c2 = (Child) p2; // 명시적 형변환 가능
		}
		System.out.println(c2.su2);
		c2.mc();
		
		Parent p3 = new Parent();
		if (p3 instanceof Child) {
			System.out.println("test2");
			Child c3 = (Child) p3;
		}
		
		//Child c3 = new Parent(); // 자동 형변환 불가능, 컴파일 오류.
		//Child c3 = (Child) new Parent(); // 명시적 형변환 불가능, 실행 오류.

	}
}
