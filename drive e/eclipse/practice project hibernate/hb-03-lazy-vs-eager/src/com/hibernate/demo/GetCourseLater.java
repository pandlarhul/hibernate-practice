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

public class GetCourseLater {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		try {
			int theId = 7;

			// create session;
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code instructor : "+instructor);
			
			session.close();
			
			System.out.println("session is closed");
			
			
			session = sessionFactory.getCurrentSession();
			
			session.beginTransaction();	
			
			
			
			
			Query<Course> query = session.createQuery("select c from Course c"
														+" where c.instructor.id=:theInstructorId",
														Course.class);
			
			
			// set parameter on Query
			query.setParameter("theInstructorId", theId);
			
			List<Course> course = query.getResultList();
			
			instructor.setCourses(course);
			
 			System.out.println("luv2code : tempCourses="+instructor.getCourses());
 			
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
