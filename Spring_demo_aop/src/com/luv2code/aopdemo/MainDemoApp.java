package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMemberDAO=context.getBean("membershipDAO",MembershipDAO.class);

		theAccountDao.addAccount();
		
		System.out.println("Deneme");
		
		theMemberDAO.addAccount();
		
		
		context.close();
		
		
		
	}

}
