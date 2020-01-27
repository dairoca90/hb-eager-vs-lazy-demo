package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory 	= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		try {
			
			
			session.beginTransaction();
			//get the instructor detail object
			int theID = 10;
			
			//print the instructor detail
			Course tempCourse = session.get(Course.class, theID);
			
			
			//print the associated instructor
			System.out.println("Deleting Course: " + tempCourse);
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done ... ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}	

}
