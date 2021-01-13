package my_demo.baseioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:my-demo/beans-annotation.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.addNew(new User());
		System.out.println(userService.getLike());
		
	}
	
}
