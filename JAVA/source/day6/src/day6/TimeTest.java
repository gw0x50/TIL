package day6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);

		// Date 기능을 Calendar 이동
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));

		// 날짜 시간을 정해서 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd E HH:mm:ss"); // E - 컴퓨터 LOCALE 정보
		String dat1 = sdf.format(now);
		String dat2 = sdf.format(cal.getTime());

		System.out.println(dat1);
		System.out.println(dat2);

		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println(df.format((double) 10 / 3));

		System.out.println(String.format("%10s", "java") + "|");
		System.out.println(String.format("%-10s", "java") + "|");
	}
}
