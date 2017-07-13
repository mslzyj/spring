package spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//吧这个类声明一个切面:需要把该类放入到IOC容器中，再声明一个切面
@Aspect
@Component

public class LoggingAspect {
	//生命该方法是一个前置通知，在目标方法开始之前执行,*表示对所有的方法都起作用(*spring.aop.impl.*.*(int,int))")
	@Before("execution(public int  spring.aop.impl.Calculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		 Object [] args=joinPoint.getArgs();
			System.out.println("the method begins：  "+ methodName+"  the method begins："+args);
    }
	//后置通知：在方法执行后（无论是否发生异常），执行的通知
	//在后置通知中，不能访问目标方法执行的结果，结果需要在返回通知里面执行
	@After("execution(public int  spring.aop.impl.Calculator.*(int,int))")
	public void afterMethod(){
		System.out.println("the method ends");
	}
}
