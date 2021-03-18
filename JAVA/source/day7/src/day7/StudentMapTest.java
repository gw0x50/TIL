package day7;

class Student<T> {
	T id;
	String name;
	int kor, eng, mat;

	Student(T id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String toString() {
		int sum = kor + eng + mat;
		return id + " - " + name + " - " + sum;
	}

	@Override
	public boolean equals(Object o) {

		int sum = kor + eng + mat;
		int othersum = ((Student) o).kor + ((Student) o).eng + ((Student) o).mat;
		if (sum == othersum)
			return true;
		else
			return false;

	}

}

public class StudentMapTest {

	public static void main(String[] args) {
		Student<Integer> s1 = new Student<Integer>(100, "김자바", 100, 90, 80);
		Student<String> s2 = new Student<String>("200", "박지원", 100, 100, 70);

		System.out.println(s1);
		System.out.println(s2);

		if (s1.equals(s2)) {
			System.out.println("두 학생의 총합이 같다.");
		}
	}

}
