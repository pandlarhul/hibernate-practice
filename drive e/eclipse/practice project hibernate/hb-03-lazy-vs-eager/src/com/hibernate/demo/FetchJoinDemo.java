package com.hibernate.demo;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = session.createQuery("select i from Instructor i"
														+" JOIN FETCH i.courses "
														+" where i.id=:theInstructorId",
														Instructor.class);
			
			
			// set parameter on Query
			query.setParameter("theInstructorId", 7);
			
			Instructor instructor = query.getSingleResult();
			
 			System.out.println("luv2code : Instructor="+instructor);
 			
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
