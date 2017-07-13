package spring09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("foctor.xml");
     Car car=(Car)ctx.getBean("car");
     System.out.println(car);
     
     car=(Car)ctx.getBean("car2");
     System.out.println(car);
	}
}
