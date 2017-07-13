package spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	public static void main(String[] args) {
        //1.����Spring ��IOC����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		//2.��IOC�����л�ȡbean��ʵ��
		Calculator aCardLayout = ctx.getBean(Calculator.class);
		//3.ʹ��bean
		int result=aCardLayout.add(3,6);
		System.out.println(result);
		
		result=aCardLayout.div(12,6);
		System.out.println(result);
	}
}
