package day4;

public class OverloadTest {

	public static void main(String[] args) {
		String s1 = "100";
		int dec = Integer.parseInt(s1);
		int bin = Integer.parseInt(s1, 2);
		System.out.println(dec);
		System.out.println(bin);
	}

}
