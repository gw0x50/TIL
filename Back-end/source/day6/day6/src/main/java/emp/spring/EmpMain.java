package emp.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class EmpMain {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("emp.xml"));
		//Derecated - 스프링에서 더이상 사용하지 말도록 권고, 대체 사용 API
		
		//ApplicationContext factory = new ClassPathXmlApplicationContext("emp/spring/emp.xml");
		VO vo = factory.getBean("vo", VO.class);
		VO vo2 = factory.getBean("vo2", VO.class);
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp(vo);
		dao.insertEmp(vo2);
		
		//주입, 의존성 주입
		System.out.println("회원 등록 마쳤습니다.");
	}

}
