package aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("aoolicationContext-Xml.xml");
     Calculator aCalculator =  ctx.getBean(Calculator.class);
     int result =aCalculator.add(3, 2);
     System.out.println(result);
     result =aCalculator.div(1000, 10);
     System.out.println(result);
	}
}
