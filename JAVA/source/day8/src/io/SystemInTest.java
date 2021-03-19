package io;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("키보드 입력을 시작하세요.");
		// 0이 입력될 때까지 입력
		/*
		 * try {
		 * while (true) {
		 * int result = System.in.read();
		 * System.out.println((char)result);
		 * if (result == -1)
		 * break;
		 * }
		 * } catch (IOException e) {
		 * e.printStackTrace();
		 * }
		 */
		try {

			InputStream is = System.in;

			byte b[] = new byte[100];

			int cnt = is.read(b); // 키보드 1바이트 입력 후 b 배열 저장
			String inputString = new String(b, 0, cnt);

			System.out.println(inputString);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
