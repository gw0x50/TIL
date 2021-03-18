package day3;

import java.util.Calendar;

public class WeekTest {

	public static void main(String[] args) {
		//타입 이름 값
		Week today = Week.WENDNESDAY;
		System.out.println(today);
		System.out.println(today.name());
		
		java.util.Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
			case 1 : 
				today = Week.SUNDAY;
				break;
			case 2 : 
				today = Week.MONDAY;
				break;
			case 3 : 
				today = Week.TUESDAY;
				break;
			case 4 : 
				today = Week.WENDNESDAY;
				break;
			case 5 : 
				today = Week.THURSDAY;
				break;
			case 6 : 
				today = Week.FRIDAY;
				break;
			case 7 : 
				today = Week.SATURDAY;
				break;
		}
		
		System.out.println(today);
	}

}
