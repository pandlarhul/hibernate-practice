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

public class GetInstructorCourseDemo {

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
//			Instructor instructor = new Instructor("Basti", "ram", "bastiram@mail.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/bastiramji","teaching 2 std ");
//			
//			instructor.setInstructorDetail(instructorDetail);

			Instructor instructor1 = new Instructor("SundarLal", "Solanki", "sundarlalsolanki@mail.com");
			
			instructor1 = session.get(Instructor.class,7);
//			
//			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/sundar","teaching and reading");
//			
//			instructor1.setInstructorDetail(instructorDetail);
//			
//			List<Course> courses = new ArrayList<Course>();
			
//			courses.add();
//			courses.add();
//			
			Course c1 = new Course("Science 10th");
			Course c2 = new Course("Mathematics 10Th"); 
			
			//instructor1.setCourses(courses);
			
//			instructor1 = session.get(Instructor.class, 1);
//			
//			System.out.println(instructor1);
//			
			instructor1.add(c1);
			instructor1.add(c2);
			
	//		c1.setInstructor(instructor1);
//			
//			// save object
//			session.save(instructor1);
			session.save(c1);
			session.save(c2);
			
			
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
