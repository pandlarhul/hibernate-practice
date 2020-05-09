package com.hibernate.demo;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorCourseDemo1 {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			System.out.println("call1");
			Instructor instructor = new Instructor("Mahipal", "kumawat", "mahipalkumawat@mail.com");
			
			instructor = session.get(Instructor.class, 7);
			
			
 			System.out.println("luv2code : Instructor="+instructor);
 			
 			instructor.getCourses();
			
 			//System.out.println("close sessioncourses:"+instructor.getCourses());
			
 			session.getTransaction().commit();
 			
 			session.close(); 			 
	 			
 			
			System.out.println("luv2code : courses="+instructor.getCourses());
			
	
 			
			
//			for(Instructor ins : allInstructor) {
//				System.out.println(ins);
//			}
			
//
//			// commit save
//			session.getTransaction().commit();
//			
			System.out.println("luv2code done");
//			session.flush();
//			session.close();
		} finally { 
			sessionFactory.close();
		}

	}

}
