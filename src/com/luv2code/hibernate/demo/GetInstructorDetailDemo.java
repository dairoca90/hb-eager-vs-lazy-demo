package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			int theID = 2;
			
			//print the instructor detail
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);
			
			
			//print the associated instructor
			System.out.println("The instructor detail info: " + instructorDetail);
			
			//print the asociated instructor
			
			System.out.println("the asociated instructor " + instructorDetail.getInstructor());
			
			
			//now let delete the instructor detail
			System.out.println("Deleting instructor detail: " 
									+ instructorDetail);
			session.delete(instructorDetail);
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
