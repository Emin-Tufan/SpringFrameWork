package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
			
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class )
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			Instructor ins=session.get(Instructor.class, 1);
		
			session.getTransaction().commit();
			
			
		}

		finally {
			
		}
	}

}
