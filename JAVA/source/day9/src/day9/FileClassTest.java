package day9;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClassTest {

	public static void main(String[] args) {
		// File f = new File("src/day9/FileClassTest.java");
		// System.out.println("파일인지 여부 = " + f.isFile());

		// System.out.println(f.exists());

		File f = new File(args[0]);
		if (f.exists()) { // 파

			try {
				System.out.println("경로 = " + f.getCanonicalPath());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			if (f.isFile()) {
				System.out.println("읽기 여부 = " + f.canRead());
				System.out.println("쓰기 여부 = " + f.canWrite());
				System.out.println("총 길이(byte) = " + f.length());

				// 4자리년도 2자리월 2자리일 24시간:2자리분:2자리초
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년도 MM월 dd일 HH:mm:ss");
				String dateString = sdf.format(new Date(f.lastModified()));
				System.out.println("최종 수정 시각 = " + dateString);
			}
			else { // d디렉토리
				String[] details = f.list();
				String result = "";
				for (String one : details) {
					File ff = new File(args[0]+"/"+one);
					if (ff.isFile()) result = " : file";
					else result = " : dir";
					System.out.println(one + " : " + ff.exists() + result);
				}

			}
		}
		else {
			System.out.println(args[0] + " 이름의 파일이나 디렉토리는 존재하지 않습니다.");
		}

	}

}
