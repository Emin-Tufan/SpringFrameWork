package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("Executing @Before advice on AddAccount()");
	}
}
