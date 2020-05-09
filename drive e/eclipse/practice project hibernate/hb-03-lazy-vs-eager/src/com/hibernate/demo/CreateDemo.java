package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

//			Instructor instructor = new Instructor("Basti", "ram", "bastiram@mail.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/bastiramji","teaching 2 std ");
//			
//			instructor.setInstructorDetail(instructorDetail);

			Instructor instructor = new Instructor("Sachin", "jangir", "sachinjangir@mail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/sachinjangir","teaching and carpenter");
			
			instructor.setInstructorDetail(instructorDetail);
			
			
			System.out.println(instructor);
			
			System.out.println(instructorDetail);
		

			// begin transcation
			session.beginTransaction();

			// save object
			session.save(instructor);

			// commit save
			session.getTransaction().commit();
			
			session.clear();
			session.flush();
			session.close();
		} finally { 
			sessionFactory.close();
		}

	}

}
