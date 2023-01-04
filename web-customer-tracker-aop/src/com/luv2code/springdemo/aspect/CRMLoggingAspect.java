package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(this.getClass().getName());

	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
	private void forAppFlow() {
	}

	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		String theMethod = theJoinPoint.getSignature().toLongString();
		myLogger.info("in @Before Calling Method : "+theMethod);
		
		Object[]arg=theJoinPoint.getArgs();
		
		for(Object args:arg) {
			myLogger.info("Arguments : "+args);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		
		String methodSignature=joinPoint.getSignature().toLongString();
		myLogger.info("@AfeterReturning : "+methodSignature);
		
		myLogger.info("Result : "+result);
	}
}
