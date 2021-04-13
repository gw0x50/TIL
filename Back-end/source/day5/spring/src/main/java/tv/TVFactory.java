package tv;

public class TVFactory {
	public static TV getTV(String name) {
		if(name.equals("LGTV")) {
			return new LGTV();
			
		}
		else if(name.equals("SamsungTV")) {
			return new SamsungTV();
		}
		return null;
	}
}
