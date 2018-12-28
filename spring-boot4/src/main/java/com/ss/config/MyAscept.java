package com.ss.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.framework.AopContext;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * aop
 *  
 *	@author huanhongzhao
 *	@date 2018年8月17日 上午11:49:03 
 *
 */
@Component
//@Aspect
public class MyAscept   {

	/**
	 * 切点
	 */
	@Pointcut(value="execution(* com.ss.controller..*.*(..))")
	public void pointCut(){
		
	}
	
	@Before("pointCut()") //前置通知
	//@After("pointCut()")  后置通知
	//@AfterThrowing("testPer()") 异常之后通知
	public void log(JoinPoint joinPoint){
		System.out.println("method done before;|   " +joinPoint.getTarget().getClass() +"  |args=" +Arrays.asList(joinPoint.getArgs()) +" |method="+ joinPoint.getSignature().getName());
		
	}
	
	//@Around(value="pointCut()") //环绕通知
	public void logRound(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("method done before");
		joinPoint.proceed();
		System.out.println("method done after");
	}

	
	
}
