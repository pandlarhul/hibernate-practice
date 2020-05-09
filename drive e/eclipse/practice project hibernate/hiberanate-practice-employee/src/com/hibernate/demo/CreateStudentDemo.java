package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

			String dob = "03/01/1998";
			
			// create student class
			Student student = new Student();
			
			student.setEmail("vendiesel@gmail.com");
			student.setFirstName("ven");
			student.setLastName("diesel");
			student.setDateOfBirth(DateUtils.parse(dob));
			//student.setId(1);

			// begin transcation
			session.beginTransaction();

			// save object
			session.save(student);

			// commit save
			session.getTransaction().commit();
			
			session.close();
		} finally {
			sessionFactory.close();
		}

	}

}
