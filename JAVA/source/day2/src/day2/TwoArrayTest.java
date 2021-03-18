package day2;

public class TwoArrayTest {

	public static void main(String[] args) {
		
		/*
		//3*4 이차원 배열
		int[] two_ar[] = new int[3][4];
		System.out.println(two_ar.length);
		System.out.println(two_ar[0].length);
		for (int i = 0; i < two_ar.length; i++) {
			for (int j = 0; j < two_ar[0].length; j++) {
				two_ar[i][j] = (i + 1) * (j + 1);
				System.out.print(two_ar[i][j] + "\t");
			}
			System.out.println();

		}
		*/
		
		//3*4 이차원 배열
		int[] two_ar[] = new int[3][];
		System.out.println(two_ar.length);
		System.out.println(two_ar[0].length);
		for (int i = 0; i < two_ar.length; i++) {
			two_ar[i] = new int[i + 2];
			
			for (int j = 0; j < two_ar[0].length; j++) {
				two_ar[i][j] = (i + 1) * (j + 1);
				System.out.print(two_ar[i][j] + "\t");
			}
			System.out.println();

		}

	}

}