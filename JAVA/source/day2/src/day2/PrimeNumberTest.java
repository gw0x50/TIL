package day2;

public class PrimeNumberTest {

	public static void main(String[] args) {

		int su = 30;

		// 소수 = 1과 자신의 수로만 나누어지는 자연수
		for (int i = 3; i <= su; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					count++;
			}
			if (count == 0)
				System.out.println(i + "는(은) 소수입니다.");
			else
				System.out.println(i + "는(은) 소수가 아닙니다.");
		}

	}
	
}
