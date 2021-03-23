class A {
	int add(int... numbers) {
		System.out.println("전달한 매개변수의 개수 : " + numbers.length);
		int sum = 0;
		for (int one : numbers) sum += one;
		return sum;
	}
}

public class VariableArgumentTest {

	 {
		A a1 = new A();
		int result = a1.add(1, 2, 5, 1, 3, 4, 5);
		System.out.println("총 합 : " + result);
	}

}
