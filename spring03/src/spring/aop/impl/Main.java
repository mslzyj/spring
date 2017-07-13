package spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	public static void main(String[] args) {
        //1.创建Spring 的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		//2.从IOC容器中获取bean的实例
		Calculator aCardLayout = ctx.getBean(Calculator.class);
		//3.使用bean
		int result=aCardLayout.add(3,6);
		System.out.println(result);
		
		result=aCardLayout.div(12,6);
		System.out.println(result);
	}
}
