package template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDAO {
	void insert(EmployeeVO vo) {
		try {
			FileWriter fw = new FileWriter("src/template/employee.txt", true);
			fw.write(vo.toString() + "\n"); // id+"|"+name+"|"+salary
			fw.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	ArrayList<EmployeeVO> getAll() {
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();

		try {
			FileReader fr = new FileReader("src/template/employee.txt");
			Scanner sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				// line 의 내용을 분리(|)
				String items[] = line.split("\\|");

				int id = Integer.parseInt(items[0]);
				String name = items[1];
				double salary = Double.parseDouble(items[2]);// 급여

				list.add(new EmployeeVO(id, name, salary));

			}
			sc.close();
			fr.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	void update(String inputId, String inputName) {
		try {
			FileReader fr = new FileReader("src/template/employee.txt");
			Scanner sc = new Scanner(fr);

			ArrayList<String> list = new ArrayList<String>();
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				// line 의 내용을 분리(|)
				String items[] = line.split("\\|");

				String id = items[0];
				String name = items[1];
				String salary = items[2];
				if (id.equals(inputId)) {
					name = inputName;
				}

				// System.out.println(id+"|"+name+"|"+salary);
				list.add(id + "|" + name + "|" + salary);

			} // while end

			sc.close();
			fr.close();

			FileWriter fw = new FileWriter("src/template/employee.txt");
			// for(int i = 0; i < list.size(); i++) {
			// fw.write(list.get(i) +"\n");
			// }
			for (String one : list) {
				fw.write(one + "\n");
			}
			fw.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
