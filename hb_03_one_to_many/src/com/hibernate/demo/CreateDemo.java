package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
			Instructor ins=session.get(Instructor.class, 1);
			
			Course course=new Course("Java-101");
			Course course1=new Course("Java-102");
			Course course2=new Course("Java-103");
			session.save(course);
			session.save(course1);
			session.save(course2);
	
			ins.add(course);
			ins.add(course1);
			ins.add(course2);
			
			session.save(ins);
			session.getTransaction().commit();			
		
			
		
			
			
			
			
		}
		finally {
			
			
		}
		

	}

}
