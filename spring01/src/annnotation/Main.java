package annnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annnotation.controlle.UserController;
import annnotation.respository.UserRepository;
import annnotation.service.UserService;

public class Main {
	public static void main(String[] args) {
	   ApplicationContext ctx =new  ClassPathXmlApplicationContext("annnotation.xml");
	   
	   TestObject to  = (TestObject) ctx.getBean("testObject");
	   System.out.println(to);
	   
	   UserController userController = (UserController) ctx.getBean("userController");
	   System.out.println(userController);
	   
	   UserService userService = (UserService) ctx.getBean("userService");
	   System.out.println(userService);
	   
	   UserRepository userRepository=(UserRepository) ctx.getBean("userRepository");
	   System.out.println(userRepository);

		System.out.println("test11");
		System.out.println("test22");
		System.out.println("test33");

		System.out.println("test44");
		System.out.println("test55");
		System.out.println("test66");
		System.out.println("test77");
	}
}
