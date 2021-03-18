package day4;

class Adding {
	public int add(int i, int j) {
		return i + j;
	}

	public double add(double i, double j) {
		return i + j;
	}

	public String add(String i, String j) {
		return i + j;
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		String s1 = "100";

		int dec = Integer.parseInt(s1);
		int bin = Integer.parseInt(s1, 2);

		System.out.println(dec);
		System.out.println(bin);

		Adding a = new Adding();

		String r1 = a.add("java", " program");
		int r2 = a.add(10, 20);
		double r3 = a.add(3.14, 2.0);

		System.out.println(r1 + ":" + r2 + ":" + r3);
	}

}
