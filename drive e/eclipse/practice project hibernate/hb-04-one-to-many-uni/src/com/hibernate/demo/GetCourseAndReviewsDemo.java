package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			int theId = 2;
			
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("Course: "+tempCourse);
			
			System.out.println("Reviews:"+tempCourse.getReviews());
			
			
			session.getTransaction().commit();
			
			session.close();
			
		}finally{
			factory.close();
		}
	}

}
