package aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    //����һ�����������������������ʽ���÷����в���Ҫ��д��������,ʹ��Pointcut�����������ʽ������ͬ־֮��ʹ�÷��������������
	//ʹ��@Pointcut�������������ʽ
	//���������ֱ֪ͨ��ʹ�÷����������û�ǰ�����������ʽ
	@Pointcut("execution(* aop.*.*(..))")
	public void declareJoinPointException(){
		
	}
	
	/*
   * �ڽӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ��һ�δ���
   * */
	//@Before("execution(public int aop.Calculator.*(int,int))")
	@Before("declareJoinPointException()")//����������ķ���
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
	    Object [] args=joinPoint.getArgs();
		System.out.println("��ʼ����  "+methodName+"  ���η����Ĳ��� :  "+args);
	}
	//@After("execution(public int aop.Calculator.*(int,int))")
	@After("declareJoinPointException()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("����������  "+methodName);
	}
	//��������������ִ�еĴ��룬���Է��ʵ������ķ���ֵ
	
	
	//@AfterReturning(value="execution(* aop.*.*(..))",returning="result")
	@AfterReturning(value="declareJoinPointException()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("���ط���: "+methodName+"  ����ֵ:"+result);
	}
	/*
	 * ��Ŀ��ġ����������쳣��ʱ���ִ�д˴���
	 * ���Է��ʵ��쳣�����ҿ���ָ���ڳ����ص��쳣ʱִ��֪ͨ����
	 * */
	//@AfterThrowing(value="execution(* aop.*.*(..))",throwing="ex")
	@AfterThrowing(value="declareJoinPointException()",throwing="ex")
	//�ڲ������쳣������²�ָ���쳣
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("�쳣�������� "+methodName+"  �쳣"+ex);
		
	}
	/*����֪ͨ:
	 * ��Ҫ��ProceedingJoinPoint���͵Ĳ���
	 * ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�����
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
	
	//@Around("execution(* aop.*.*(..))")
	@Around("declareJoinPointException()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		try {
			//ǰ��֪ͨ
			System.out.println("the method "+ methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			//ִ��Ŀ�귽��
			result=pjd.proceed();
			//����֪ͨ
			System.out.println("The method end with:"+result);
		} catch (Throwable e) {
			// �쳣֪ͨ
			System.out.println("The method "+methodName+"occurs exception:"+e);
			throw new RuntimeException(e);
		}
		//����֪ͨ
		System.out.println("the method "+methodName+"ends");
		return result;
	}
}
