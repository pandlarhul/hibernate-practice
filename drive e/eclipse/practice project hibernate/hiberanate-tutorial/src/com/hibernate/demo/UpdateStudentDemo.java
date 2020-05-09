package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			Student st = new Student();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email=\'foo@dudh.om\'").executeUpdate();
				
			session.getTransaction().commit();
			
			
			session.close();
		} finally {
			factory.close();
		}

	}

}
