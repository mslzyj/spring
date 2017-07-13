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
    //定义一个方法，用于声明切入点表达式，该方法中不需要编写其他代码,使用Pointcut声明切入点表达式，其他同志之间使用方法名引入切入点
	//使用@Pointcut来生命切入点表达式
	//后面的其他通知直接使用方法名来引用或当前得问切入点表达式
	@Pointcut("execution(* aop.*.*(..))")
	public void declareJoinPointException(){
		
	}
	
	/*
   * 在接口的每一个实现类的每一个方法开始之前执行一段代码
   * */
	//@Before("execution(public int aop.Calculator.*(int,int))")
	@Before("declareJoinPointException()")//引用上面你的方法
	public void beforeMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
	    Object [] args=joinPoint.getArgs();
		System.out.println("开始方法  "+methodName+"  带参方法的参数 :  "+args);
	}
	//@After("execution(public int aop.Calculator.*(int,int))")
	@After("declareJoinPointException()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("结束方法：  "+methodName);
	}
	//在正常方法结束执行的代码，可以访问到方法的返回值
	
	
	//@AfterReturning(value="execution(* aop.*.*(..))",returning="result")
	@AfterReturning(value="declareJoinPointException()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("返回方法: "+methodName+"  返回值:"+result);
	}
	/*
	 * 在目标的、方法出现异常的时候会执行此代码
	 * 可以访问到异常对象，且可以指定在出现特点异常时执行通知代码
	 * */
	//@AfterThrowing(value="execution(* aop.*.*(..))",throwing="ex")
	@AfterThrowing(value="declareJoinPointException()",throwing="ex")
	//在不出现异常的情况下不指出异常
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("异常处理方法： "+methodName+"  异常"+ex);
		
	}
	/*环绕通知:
	 * 需要带ProceedingJoinPoint类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标代码
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	
	//@Around("execution(* aop.*.*(..))")
	@Around("declareJoinPointException()")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		try {
			//前置通知
			System.out.println("the method "+ methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result=pjd.proceed();
			//返回通知
			System.out.println("The method end with:"+result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("The method "+methodName+"occurs exception:"+e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("the method "+methodName+"ends");
		return result;
	}
}
