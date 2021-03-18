package day2;

public class NullTest {

	public static void main(String[] args) {
		String s1 = "abcd";
		System.out.println(s1);
		
		if (s1 != null)
			System.out.println(s1.toUpperCase());
		
		String sa = "java";
		String sb = "java";
		String sc = new String("java");
		String sd = new String("java");

		if (sa == sb)
			System.out.println("sa == sb");
		if (sb == sc)
			System.out.println("sb == sc");
		if (sc == sd)
			System.out.println("sc == sd");
		
		// 참조형 변수 == 연산자 동등성 비교 -> 주소값 동일 비교
		// String.equals() 메소드 동등성 비교 -> 문자열내용 동일 비교
		
		if (sa.equals(sb))
			System.out.println("sa.equals(sb)");
		if (sb.equals(sc))
			System.out.println("sb.equals(sc)");
		if (sc.equals(sd))
			System.out.println("sc.equals(sd)");
		

	}

}
