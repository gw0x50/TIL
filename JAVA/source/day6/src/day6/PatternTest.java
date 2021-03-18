package day6;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "012-1234-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123-5678"));
		System.out.println(Pattern.matches("010-[0-9]{3,4}-[0-9]{4}", "010-123a-5678"));

		String myEmail = "javadosa1!@campus.com";
		boolean result = Pattern.matches("[a-zA-Z0-9!#$%_]{8,10}@[a-zA-Z0-9!#$%_]{3,10}\\.(com|co.kr|go.kr)", myEmail);
		if (result == true) {
			System.out.println(myEmail + " 은 이메일로 적합합니다.");
		}

	}

}
