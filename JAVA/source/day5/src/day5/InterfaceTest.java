package day5;

class StudentTeacher implements Student, Teacher {
	String name = "조교";

	@Override
	public void teach() {
		System.out.println("선생님 가르치다.");
	}

	@Override
	public void study() {
		System.out.println(Student.name);
		System.out.println(Teacher.name);
		System.out.println("학생 공부하다.");
	}

	@Override
	public void lunch() {
		System.out.println("학생과 선생님 점심먹다.");
	}

}

class ITTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("선생님 가르치다.");
	}

	@Override
	public void lunch() {
		System.out.println("학생과 선생님 점심먹다.");
	}

}

public class InterfaceTest {

	public static void main(String[] args) {
		/* StudentTeacher st = new
		 * StudentTeacher(); st.study();
		 * st.lunch(); st.teach();
		 * Teacher tr = new
		 * StudentTeacher();
		 * //tr.study(); tr.lunch();
		 * tr.teach();
		 * System.out.println(tr.name);
		 * Teacher[] t = new Teacher[2];
		 * t[0] = new StudentTeacher();
		 * t[1] = new ITTeacher(); t[0]
		 * = teach(); t[0] = lunch();
		 * t[1] = teach(); t[1] =
		 * lunch(); StudentTeacher st =
		 * (StudentTeacher) t[0];
		 * st.study(); */
	}

}
