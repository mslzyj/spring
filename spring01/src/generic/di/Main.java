package generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("genenic.id.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
	}
}
