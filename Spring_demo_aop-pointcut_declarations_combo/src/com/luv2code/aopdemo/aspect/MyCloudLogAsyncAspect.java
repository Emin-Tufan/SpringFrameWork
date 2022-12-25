package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 1)
public class MyCloudLogAsyncAspect {


	@Before("com.luv2code.aopdemo.aspect.MyDemoLoggingAspect.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("@Before advice on method");
	}

}
