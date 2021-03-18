package day5;

public class ObjectClassTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("java");
		MyObject o2 = new MyObject("java");
		System.out.println(o1);
		System.out.println(o2);

		if (o1 == o2) {
			System.out.println("== true");
		}
		if (o1.equals(o2)) {
			System.out.println("equals true");
		}
	}

}

class MyObject {
	String msg;

	MyObject(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyObject) {
			return toString().equals(obj.toString());
		} else {
			return false;
		}
	}
}