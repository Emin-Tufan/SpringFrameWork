package com.hibernate.demo;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CourseAndStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student st=session.get(Student.class, 5);
			session.delete(st);
			
	

			session.getTransaction().commit();
			
		}
		finally {
		
			session.close();
			factory.close();
		}

	}

}
