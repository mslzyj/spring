package aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 验证切面
 * */
@Order(2)//指定切面的优先级，值越小优先级越高
@Aspect
@Component
public class VlidationAspect {
    //@Before("execution(* aop.*.*(..))")
    @Before("LoggingAspect.declareJoinPointException()")
	public void validateArgs(JoinPoint joinPoint){
	  System.out.println("validate:"+Arrays.asList(joinPoint.getArgs()));
  }
}
