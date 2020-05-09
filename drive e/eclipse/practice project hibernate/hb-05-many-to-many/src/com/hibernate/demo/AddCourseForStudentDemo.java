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

public class AddCourseForStudentDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Student.class)
							.addAnnotatedClass(Review.class)
							.buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			Course c1 =new Course("angular.js");
			Course c2 = new Course("react.js");
			
			c2 = session.get(Course.class, 22);
			
			Student st ;//= new Student("Vipin", "sharma", "vipinsharma19794@gmail.com");
			st = session.get(Student.class, 4);
			
			
			c2.addStudent(st);
			//session.save(c2);
		
			
			
			System.out.println("courses to 14 id="+c2.getStudent());
			
			System.out.println("Student 5:"+st);
			System.out.println("courses enrolled by student 5:"+st.getCourses());
			
			
			
			
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
