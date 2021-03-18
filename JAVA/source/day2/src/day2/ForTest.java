package day2;

public class ForTest {

	public static void main(String[] args) {
		// 1-10 자연수 총
		int sum = 0;
		int i = 0;
		for (i = 1; i <= 10; i++) {
			if (i == 5)
				continue;
			sum = sum + i;
			System.out.println(i + " 값까지의 정수 총합 = " + sum);
		}
		System.out.println(i + " 값까지의 정수 총합 = " + sum);

		// 학생 10명 자바시험 => 1-100 10개 점수 만들기

		for (int j = 0; j < 10; j++) {
			int score = (int) (Math.random() * 100) + 1;
			System.out.println("학생 " + (j + 1) + "의 점수 : " + score);
		}
	}
}
