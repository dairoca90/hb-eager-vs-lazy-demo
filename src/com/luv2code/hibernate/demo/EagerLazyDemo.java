package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory 	= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			int theId = 1;
			
			
			//start a transaction
			
			//get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Luv2 code: Instructor" + tempInstructor);
			
			System.out.println("Luv2 code: Courses : " +tempInstructor.getCourses());
			
			
			
			session.getTransaction().commit();
			
			
			//Close the session
			session.close();
			
			System.out.println("\nThe session is now close\n");
			//since courses are lazy loaded... this should fail
			System.out.println("Luv2 code: Courses : " +tempInstructor.getCourses());
			
			System.out.println("Luv2 code: Done");
			
			
		}finally {
			
			//add clean up code
			
			session.close();
			factory.close();
		}
	}	

}
