package day9;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest2 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(args[0]);
			fw = new FileWriter(args[1], true);
			while (true) {

				int result = fr.read();
				fw.write(result);
				if (result == -1) break;

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
