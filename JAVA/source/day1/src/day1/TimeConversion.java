package day1;

public class TimeConversion {

	public static void main(String[] args) {
		int time = 10000; // 초단위 시간
		int time2 = time;
		// 시분초단위 변경 출력
		// 10000초는 xx 시간 xx 분 xx 초입니다.
		// 1시간 = 3600초, 1분 = 60초 
			
		int hour = time / 3600;
		time = time % 3600;
		int minute = time / 60;
		int second = time % 60;
		
		System.out.println(time2 + " 초는 " + hour + " 시간 "+ minute + " 분 " + second + " 초입니다.");
		
		// hour 변수 24시간 초과되면 "만 1일 경과했습니다" 출력
		// 아니면 "1일 이내입니다" 출력
		
		String day = hour > 24?"만 1일 경과했습니다.":"1일 이내입니다.";
		System.out.println(day);
	}

}
