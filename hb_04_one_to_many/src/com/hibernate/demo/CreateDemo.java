package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
		
		Course c=session.get(Course.class, 10);
			c.addReview(session.get(Review.class,1));
			
			session.save(c);
		
			
			
			session.getTransaction().commit();	
		
			
		
			
			
			
			
		}
		finally {
			
			factory.close();
			session.close();
		}
		

	}

}
