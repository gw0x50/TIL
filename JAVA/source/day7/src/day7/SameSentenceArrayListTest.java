package day7;

import java.util.ArrayList;

class SameSentenceArrayList {
	String[] compare(ArrayList<String> list1, ArrayList<String> list2) {
		String[] result = null;
		ArrayList<String> resultList = new ArrayList<String>();
		/* list1, list2 데이터 갯수 비교 다르면
		 * "최소 (작은쪽의 갯수)3개, 최대 (큰쪽 갯수)4개의 리스트입니다"
		 * 를 result 배열에 넣어서 리턴 같으면 2개
		 * ArrayList 각 인덱스마다 문자열 내용 비교하고
		 * 같을 문자열 내용 같으면 result 배열에 넣어서
		 * 리턴 */
		int len1 = list1.size();
		int len2 = list2.size();

		if (len1 > len2) {
			resultList.add("최소 " + len2 + "개, 최대 " + len1 + "개의 리스트 입니다.");

		} else if (len1 < len2) {
			resultList.add("최소 " + len1 + "개, 최대 " + len2 + "개의 리스트 입니다.");
		} else {
			for (int i = 0; i < len1; i++) {
				if (list1.get(i).equals(list2.get(i))) {
					resultList.add(list1.get(i));
				}
			}
		}
		result = new String[resultList.size()];
		resultList.toArray(result);
		return result;
	}
}

public class SameSentenceArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("자바는 객체지향 언어입니다");
		list1.add("우리는 멀티캠퍼스에서 자바를 배우는 중입니다");
		list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		list1.add("람다, 입출력과 네트워크도 배울 예정입니다 ");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("자바는 객체지향 언어입니다");
		list2.add("우리는 multicampus에서 자바를 배우는 중입니다");
		list2.add("오늘은 컬렉션 프레임워크를 배우죠! ");
		list2.add("입출력과 네트워크도 배울 예정입니다 ");

		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("자바는 객체지향 언어입니다");
		list3.add("우리는 multi에서 자바를 배우는 중입니다");
		list3.add("오늘은 컬렉션 프레임워크를 배우죠! ");

		SameSentenceArrayList ss = new SameSentenceArrayList();
		String[] a = ss.compare(list1, list2);//list1, list2에서 같은 내용만 출력
		String[] b = ss.compare(list1, list3);//최소 3개, 최대 4개의 리스트입니다 출력	

		for (String text : a) {
			System.out.println(text);
		}

		for (String text : b) {
			System.out.println(text);
		}

	}
}
