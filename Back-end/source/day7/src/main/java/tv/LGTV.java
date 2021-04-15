package tv;

public class LGTV implements TV{
	public void powerOn() {
		System.out.println("LG tv - 전원 켜다.");
	}
	public void powerOff() {
		System.out.println("LG tv - 전원 끄다.");
	}
	public void soundUp() {
		System.out.println("LG tv - 볼륨 높이다.");
	}
	public void soundDown() {
		System.out.println("LG tv - 볼륨 낮추다.");
	}
}
