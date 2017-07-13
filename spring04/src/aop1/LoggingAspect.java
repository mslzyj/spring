package aop1;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void declareJoinPointException(){}
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
	    Object [] args=joinPoint.getArgs();
		System.out.println("开始方法  "+methodName+"  带参方法的参数 :  "+args);
	}
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("结束方法：  "+methodName);
	}
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("返回方法: "+methodName+"  返回值:"+result);
	}
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("异常处理方法： "+methodName+"  异常"+ex);
		
	}
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		try {
			//前置通知
			System.out.println("the method "+ methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
			//后置通知
			System.out.println("The method end with:"+result);
		} catch (Throwable e) {
			// 异常通知
			e.printStackTrace();
		}
		//后置通知
		return result;
	}
}
