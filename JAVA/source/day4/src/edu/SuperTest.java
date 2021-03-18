package edu;

class A {
	int i;
	
	A() { }
	A(String s) {
		i = 10;
		System.out.println("A 생성자 호출");
	}
}	

class B extends A {
	int j;

	B() {
		j = 100;
		System.out.println("B 생성자 호출");
	}
}

public class SuperTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);
	}

}
