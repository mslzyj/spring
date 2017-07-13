package aop1;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void declareJoinPointException(){}
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
	    Object [] args=joinPoint.getArgs();
		System.out.println("��ʼ����  "+methodName+"  ���η����Ĳ��� :  "+args);
	}
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("����������  "+methodName);
	}
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("���ط���: "+methodName+"  ����ֵ:"+result);
	}
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("�쳣�������� "+methodName+"  �쳣"+ex);
		
	}
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		try {
			//ǰ��֪ͨ
			System.out.println("the method "+ methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			result=pjd.proceed();
			//����֪ͨ
			System.out.println("The method end with:"+result);
		} catch (Throwable e) {
			// �쳣֪ͨ
			e.printStackTrace();
		}
		//����֪ͨ
		return result;
	}
}
