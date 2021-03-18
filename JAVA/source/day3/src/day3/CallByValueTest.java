package day3;

class MyObject{
	int a = 10;
}

class Call {
	void add(int i) {
		System.out.println(i++);
	}
	void addObject(MyObject mo) {
		System.out.println(mo.a++);
	}
}

public class CallByValueTest {
	
	public static void main(String args[]) {
		Call c = new Call();
		//int j = 10;
		//c.add(j);
		//System.out.println("c.add(j) 호출 후의 j = " + j);
		MyObject obj = new MyObject();
		c.addObject(obj);
		System.out.println("c.addObject(obj) 호출 후의 ob0j = " + obj.a);
	}
}
