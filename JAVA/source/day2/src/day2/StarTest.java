package day2;

public class StarTest {

	public static void main(String[] args) {
		// 5*5 사각형 모양 * 출력

		// 5개*
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		//
		char c = 'a';
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(c);
				c++;
			}
			System.out.println();
		}
		System.out.println();
	}

}
