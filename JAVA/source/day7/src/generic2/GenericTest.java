package generic2;

class Fruit {
	String name = "과일";
}

class Apple extends Fruit {
	String origin;

	Apple(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}

}

class Orange extends Fruit {
	String imported;

	Orange(String name, String imported) {
		this.name = name;
		this.imported = imported;
	}
}

class Paper {
	String size = "A4";
}

class Box<T extends Fruit> {

	//멤버변수 / 생성자 / 메소드 
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

class BoxManager {
	public void test(Box<? extends Fruit> b) {
		System.out.println(b.getO().name);
	}
}

public class GenericTest {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		Apple a = new Apple("사과", "대구");
		Orange o = new Orange("오렌지", "미국");
		Paper p = new Paper();

		Box<Fruit> box1 = new Box<Fruit>(f);
		Box<Apple> box2 = new Box<Apple>(a);
		Box<Orange> box3 = new Box<Orange>(o);
		//Box<Paper> box4 = new Box<Paper>(p);
		
		BoxManager m = new BoxManager();
		m.test(box1);
		m.test(box2);
		m.test(box3);
	}

}
