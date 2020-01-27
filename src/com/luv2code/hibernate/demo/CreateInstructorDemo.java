package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			//create the objects
			Instructor tempInstructor =
					new Instructor("Susan","Public","susan.public@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://www.youtube.com","Guitar");
			
			tempInstructor.setInstructorDatail(tempInstructorDetail);
			
			System.out.println("Salvando instructor :" + tempInstructor );
			
			session.save(tempInstructor);
			System.out.println("Done");
			
			
		}finally {
			
			//add clean up code
			
			session.close();
			factory.close();
		}
	}	

}
