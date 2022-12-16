package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory factory =new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Query<Instructor>ins=session.createQuery("Select i from Instructor i "
					+ "Join Fetch i.courses "
					+ "Where i.id=:theInstructorId",Instructor.class);
			
			ins.setParameter("theInstructorId", 1);
			Instructor instructor=ins.getSingleResult();
			System.out.println(instructor);
			
			
		}
		finally {
			
			
		}
								
								
								

	}

}
