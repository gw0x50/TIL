package day5;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[0]);
			System.out.println(i / j);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("0 입력 불가.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("모든 예외 동일처리.");
			e.printStackTrace();
		} finally {
			System.out.println("항상 실행합니다.");
		}
		/* catch (NumberFormatException
		 * e) { System.out.
		 * println("정수로 변환 가능한 값을 입력하세요."
		 * ); e.printStackTrace(); }
		 * catch
		 * (ArrayIndexOutOfBoundsException
		 * e) { System.out.
		 * println("2개 이상의 값을 입력하세요.");
		 * e.printStackTrace(); } */

		System.out.println("main 종료.");

	}

}
