package nongeneric;

class Apple {
	String origin = "대구";
}

class Paper {
	String size = "A4";
}

class Box<T> {
	T o;

	Box(T o) {
		this.o = o;
	}

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}

}

public class GenericTest {

	public static void main(String[] args) {

		Apple a = new Apple();
		Paper p = new Paper();
		
		Box<Apple> appleBox = new Box<Apple>(a);
		Box<Paper> paperBox = new Box<Paper>(p);
		
		System.out.println(appleBox.getO().origin);
		System.out.println(paperBox.getO().size);
		
		if (appleBox.getO() instanceof Apple)
			System.out.println(((Apple) appleBox.getO()).origin);
		if (paperBox.getO() instanceof Paper)
			System.out.println(((Paper) paperBox.getO()).size);

	}

}
