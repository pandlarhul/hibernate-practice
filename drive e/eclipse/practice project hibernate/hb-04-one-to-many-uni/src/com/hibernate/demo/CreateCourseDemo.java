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
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Review.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

			// begin transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman how to score one million points");
			
			tempCourse.addReviews(new Review("Nice for pacman"));
			tempCourse.addReviews(new Review("you can get nice score through it"));
			tempCourse.addReviews(new Review("dont use it"));

			session.save(tempCourse);
			
			
			// commit save
			session.getTransaction().commit();
			
		
			session.close();
		} finally { 
			sessionFactory.close();
		}

	}

}
