package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
     Calculator aCalculator = (Calculator) ctx.getBean("calculatorImpl");
     int result =aCalculator.add(1, 2);
     System.out.println(result);
     
     result =aCalculator.div(10, 1);
     System.out.println(result);
	}
}
