package aop1;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//指定切面的优先级，值越小优先级越高
@Order(1)
@Aspect
@Component
public class VlidationAspect {
   //	@Before("execution(public int aop1.Calculator.*(..))")
	@Before("LoggingAspect.declareJoinPointException()")
	public void validateArgs(JoinPoint joinPoint){
	  System.out.println("validate:"+Arrays.asList(joinPoint.getArgs()));
  }
}
