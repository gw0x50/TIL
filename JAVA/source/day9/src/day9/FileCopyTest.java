package day9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		try {
			FileInputStream fi = new FileInputStream(args[0]);
			FileOutputStream fo = new FileOutputStream(args[1], true);
			while (true) {

				int result = fi.read();
				fo.write(result);
				if (result == -1) break;

			}

			fi.close();
			fo.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
