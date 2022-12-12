package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
	
			session.beginTransaction();
			Instructor tempStudent= session.get(Instructor.class, 5);
			session.delete(tempStudent);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			session.close();
			
		}
		
		
		
	}
	

}
