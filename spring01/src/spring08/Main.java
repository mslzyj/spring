package spring08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cycle.xml");
		Car car = (Car) ctx.getBean("car");
		ctx.close();
	}

}
