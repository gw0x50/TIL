package day5;

public class CheckedExceptionTest {

	public static void main(String[] args) {
		try {
			Class.forName("day5.CheckedExceptionTest");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		int su = Integer.parseInt("-100");
		try {
			if (su <= 0) {
				throw new NumberFormatException("소수 구하기 부적합 합니다.");
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
