package day7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		//HashSet set = new HashSet();
		//set.add(100);
		//set.add(3.14);
		//set.add("java");
		//set.add(100); // 무시

		HashSet<Employee> set = new HashSet<Employee>();
		Employee e1 = new Employee(400, "박부장", 88000.99);
		set.add(e1);
		//set.add(new Employee(400, "박부장", 88000.99)); // 새로운 객체를 생성하기 때문에 add

		System.out.println(set.size());

		Iterator<Employee> it = set.iterator();
		while (it.hasNext()) {
			Employee o = it.next();
			System.out.println(o.name);
		}

		
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		while (lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		
		/*
		Iterator<Integer> lottoIt = lotto.iterator();
		
		while (lottoIt.hasNext()) {
			Integer i = lottoIt.next();
			System.out.println(i);
		}
		*/
		
		for(Integer i : lotto) {
			System.out.println(i);
		}
		
		
	}

}
