package template;

import java.util.ArrayList;

public class Controller {
	// Singleton Pattern
	static private Controller con = new Controller();

	private Controller() {
	}

	public static Controller getInstance() {
		return con;
	}

	// 사원 등록 제어 부문
	void insert(int id, String name, double salary) {
		EmployeeVO vo = new EmployeeVO(id, name, salary);
		EmployeeDAO dao = new EmployeeDAO();
		dao.insert(vo);
	}

	ArrayList<EmployeeVO> getAll() {
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeVO> list = dao.getAll();
		return list;
	}

	void update(String inputId, String inputName) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.update(inputId, inputName);
	}
}
