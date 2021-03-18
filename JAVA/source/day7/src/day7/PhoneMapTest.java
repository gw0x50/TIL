package day7;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		HashMap<String, String[]> phone = new HashMap<String, String[]>();

		phone.put("초등친구", new String[] { "010-1234-5678", "02-1234-5678", "031-1234-5678", "a@naver.com" });
		phone.put("고등친구", new String[] { "010-2234-5678", "02-2234-5678", "b@naver.com" });
		phone.put("회사동기", new String[] { "010-3234-5678", "c@naver.com" });
		phone.put("회사상사", new String[] { "010-4234-5678", "02-4234-5678", "d@naver.com" });
		phone.put("회사상사", new String[] { "010-4234-5678", "031-4234-5678", "d@naver.com" });

		System.out.println("총 연락처 갯수 = " + phone.size());

		if (phone.containsKey("회사동기")) {
			String[] phonelist = phone.get("회사동기");
			for (String one : phonelist) {
				System.out.println(one);
			}
		}

		if (phone.containsKey("사장님")) {
			String[] phonelist = phone.get("사장님");
			for (String one : phonelist) {
				System.out.println(one);
			}
		}
		
		Set<String> keys = phone.keySet();
		for(String k : keys) {
			System.out.print(k + " : ");
			String[] phonelist = phone.get(k);
			for(String one : phonelist) {
				System.out.print(one + " | ");
			}
			System.out.println();
		}
	}

}