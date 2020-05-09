package com.hibernate.demo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteCourse {

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
			
			Course course = session.get(Course.class, 3);
			
			
			//List<Course> courses = session.createQuery("from course").getResultList();
			
			
			System.out.println(course);
			
			session.delete(course);
			
			
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
