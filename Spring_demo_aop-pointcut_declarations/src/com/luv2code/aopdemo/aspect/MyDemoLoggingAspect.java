package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	@Before("forPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("Executing @Before advice on AddAccount()");
	}
	
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	};
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {
		
		System.out.println("This is Getter Method");
	}
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {
		
		System.out.println("This is Getter Method");
	}
	
}
