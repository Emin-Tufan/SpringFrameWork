package com.hibernate.practice.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.demo.entity.DateUtil;
import com.hibernate.practice.demo.entity.Employee;

public class EmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Date date=DateUtil.parseDate("11/03/2003");
			Employee tempEmployee=new Employee("Emin","Tufan","Logo",date);
			session.save(tempEmployee);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			
		}

	}

}
