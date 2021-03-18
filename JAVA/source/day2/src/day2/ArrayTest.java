package day2;

import java.text.DecimalFormat;

public class ArrayTest {
	public static void main(String[] args) {
		// 5명 학생 시험점수
		String[] names = new String[5];
		int[][] scores = new int[names.length][3];
		double avg[] = new double[names.length];

		// 이름 저장
		names[0] = "홍미미";
		names[1] = "이민정";
		names[2] = "서형준";
		names[3] = "김범근";
		names[4] = "김우일";

		/* scores 배열내에
		 * 첫 번째 학생의 국어 영어 수학
		 * 두 번째 학생의 국어 영어 수학
		 * 세 번째 학생의 국어 영어 수학
		 * 네 번째 학생의 국어 영어 수학
		 * 다섯 번째 학생의 국어 영어 수학
		 * 점수를 1 - 100 난수 발생 초기화 출력 
		 * 각 학생별 3과목 실수평균 저장 배열 저장하고 출력 */

		for (int i = 0; i < names.length; i++) {
			int sum = 0;
			System.out.print(names[i] + "\t:\t");
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int) ((Math.random()) * 100) + 1;
				System.out.print(scores[i][j] + "\t");
				sum += scores[i][j];
			}
			avg[i] = (double) sum / scores[i].length;
			java.text.DecimalFormat dec = new DecimalFormat("##.00");
			System.out.println("avg = " + dec.format(avg[i]));
		}
		
		String [] names2 = new String [10];
		
		for (int i = 0; i < names.length; i++) {
			names2[i] = names[i];
		}
		for (int i = 0; i < names2.length; i++) {
			System.out.println(names2[i]);
		}
		for (String n : names2) {
			System.out.println(n);
		}
		
		

		/* 이름 저장
		 * names[0] = "홍미미";
		 * names[1] = "이민정";
		 * names[2] = "서형준";
		 * names[3] = "김범근";
		 * names[4] = "김우일";
		 * 
		 * 시험점수 저장
		 * scores[0] = 100;
		 * scores[1] = 77;
		 * scores[2] = 100;
		 * scores[3] = 77;
		 * scores[4] = 100;
		 * System.out.println("학생수 = 점수갯수 : " + scores.length);
		 * System.out.println("학생수 = 이름갯수 : " + names.length);
		 * for (int i = 0; i < 5; i++) {
		 * 	System.out.println(names[i] + " = " + scores[i]);
		 * }
		 */
	}
}
