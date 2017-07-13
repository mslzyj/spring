package spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//�����������һ������:��Ҫ�Ѹ�����뵽IOC�����У�������һ������
@Aspect
@Component

public class LoggingAspect {
	//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��,*��ʾ�����еķ�����������(*spring.aop.impl.*.*(int,int))")
	@Before("execution(public int  spring.aop.impl.Calculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		 Object [] args=joinPoint.getArgs();
			System.out.println("the method begins��  "+ methodName+"  the method begins��"+args);
    }
	//����֪ͨ���ڷ���ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	//�ں���֪ͨ�У����ܷ���Ŀ�귽��ִ�еĽ���������Ҫ�ڷ���֪ͨ����ִ��
	@After("execution(public int  spring.aop.impl.Calculator.*(int,int))")
	public void afterMethod(){
		System.out.println("the method ends");
	}
}
