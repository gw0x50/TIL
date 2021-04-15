package tv.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("tv/spring/tv.xml");
		
		TV tv = factory.getBean("tv", TV.class);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		TV tv2 = factory.getBean("tv", TV.class);
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
		
		tv = factory.getBean("tv", TV.class);
		tv = factory.getBean("tv", TV.class);
		tv = factory.getBean("tv", TV.class);
	}
}
