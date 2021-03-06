package day2;

public class IfTest {

	public static void main(String[] args) {
		// 이자바학생 국어 영어 수학 100 88 77
		// 총점 / 정수평균 / 실수평균
		// 정수평균 70점 이상 합격/불합격

		String name = "이자바";
		// 1-100 사이의 난수 발
		int kor = (int) (Math.random() * 100) + 1; // 자동 수정 - 실행
		int eng = (int) (Math.random() * 100) + 1;
		int mat = (int) (Math.random() * 100) + 1;
		int sum = kor + eng + mat;
		int avgInt = sum / 3;
		double avgDouble = (double) sum / 3;

		System.out.println("학생이름 = " + name);
		System.out.println("국이 = " + kor);
		System.out.println("영어 = " + eng);
		System.out.println("수학 = " + mat);
		System.out.println("총점 = " + sum);
		System.out.println("평균(정수) = " + avgInt);
		System.out.println("평균(실수) = " + avgDouble);

		/*
		 * if(avgInt >= 70) { System.out.println("p" + "ss");
		 * System.out.println("공부 열심히 하셨습니다."); } else { System.out.println("fail");
		 * System.out.println("공부 더 열심히 하셔야죠!!!"); }
		 * 
		 * System.out.println(avgInt >= 70?"pass":"faill");
		 */

		// 80이상 A등급
		// 60이상이고 80미만 B등급
		// 40이상이고 60미만 C등급
		// 나머지 낙제

		/*
		 * if(avgInt >= 80) { System.out.println("A등급"); }else if(avgInt >= 60) {
		 * System.out.println("B등급"); }else if(avgInt >= 40) {
		 * System.out.println("C등급"); }else { System.out.println("낙제"); }
		 */

		switch (avgInt / 10) {
			case 10:
			case 9:
			case 8:
				System.out.println("A등급");
				break;
			case 7:
			case 6:
				System.out.println("B등급");
				break;
			case 5:
			case 4:
				System.out.println("C등급");
				break;
			default:
				System.out.println("낙제");
		}
	}

}
