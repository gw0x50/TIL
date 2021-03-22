package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest3 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("src/day9/FileCopyTest3.java");
			fw = new FileWriter("linecopy.txt");
			Scanner sc = new Scanner(fr);
			int lineNum = 1;

			while (sc.hasNextLine()) {
				String line = sc.nextLine(); // \n 이전 문자까지 입력
				// System.out.print(lineNum++ + " : " + line + "\n");
				fw.write(lineNum++ + " : " + line + "\n");
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
				fw.close();
			}
			catch (IOException e) {

			}

		}

	}

}
