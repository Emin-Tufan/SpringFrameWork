package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			//Query Search
			session.beginTransaction();
			//List <Student>getStudentList=session.createQuery("from Student").getResultList();
			//displayStudents(getStudentList);
			
			// Conditional Query Search
			//	getStudentList=session.createQuery("from Student a where a.name='Emin'").getResultList();
			//	displayStudents(getStudentList);
			
			//getStudentList=session.createQuery("from Student a where a.email like 'e%'").getResultList();
			//displayStudents(getStudentList);
			

			
			//HQL Update & Delete Process
			//session.get(Student.class,1).setName("Emin");
			//session.getTransaction().commit();
			//session.createQuery("update Student set first_name='Mahmut' where id=1").executeUpdate();
			
			//Student student=session.get(Student.class, 1);
			//session.delete(student);
			//session.createQuery("update from Student set last_name='Ersever' where id=5").executeUpdate();
			//session.getTransaction().commit();
			
		}
		finally {
			factory.close();
			session.close();
		}
	
	}

	private static void displayStudents(List<Student> getStudentList) {
		for(Student s: getStudentList) {
			System.out.println(s);
		}
	}

}
