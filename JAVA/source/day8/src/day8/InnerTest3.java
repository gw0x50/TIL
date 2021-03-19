package day8;

public class InnerTest3 {

	public static void main(String[] args) {
		int out = 10;
		class Inner {
			public int count() {
				int cnt = 0;
				for (int i = 0; i < out; i++) {
					cnt += i;
				}
				return cnt;
			}
		}
		System.out.println(new Inner().count());

		/*
		 * // 지역 내부 클래스
		 * class RunnableSub implements Runnable {
		 * @Override
		 * public void run() {
		 * System.out.println("실행 중");
		 * }
		 * }
		 * // 지역 내부 객체 생성
		 * Runnable sub = new RunnableSub();
		 * // 메소드 호출
		 * Thread t1 = new Thread(sub);
		 * t1.start();
		 */

		new Thread(new Runnable() {
			public void run() {
				System.out.println("실행 중");
			}
		}).start();
		
		new Thread( () -> {System.out.println("lambda test");}).start();

		myInter i = new myInter() {

			@Override
			public void mi1() {
				System.out.println("mi1");
			}

			@Override
			public void mi2() {
				System.out.println("mi2");
			}
			
			public void mi3() {
				System.out.println("하위 추가 메소드 mi3");
			}
		};
		
		i.mi1();
		i.mi2();
		//i.mi3();
	}
}

	interface myInter {
		void mi1();

		void mi2();

	}

abstract class A {
	abstract void ma();
	
}
