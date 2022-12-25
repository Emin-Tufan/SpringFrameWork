	package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMemberDAO=context.getBean("membershipDAO",MembershipDAO.class);
		Account theAccount=context.getBean("account",Account.class);
		Hello hello=context.getBean("hello",Hello.class);
		
		theAccountDao.addAccount();
		
		System.out.println("--------------------------------------");
		
		theMemberDAO.addAccount();
		
		System.out.println("--------------------------------------");
		
		System.out.println(theAccount.getName());
		
		System.out.println("--------------------------------------");

		theAccount.selam();

		System.out.println("--------------------------------------");
		
		theAccount.setLevel("merhaba");
		
		System.out.println("--------------------------------------");
		
		hello.selamHerkese();
		
		context.close();
		
		
		
	}

}
