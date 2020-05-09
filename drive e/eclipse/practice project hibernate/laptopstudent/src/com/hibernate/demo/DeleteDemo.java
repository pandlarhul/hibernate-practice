package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		try {
			System.out.println("call1");
			
			// create session;
			Session session = sessionFactory.getCurrentSession();

			System.out.println("call2");
			
			// begin transcation
			session.beginTransaction();
			
			System.out.println("call3");
			

			Instructor ins = session.get(Instructor.class, 3);
			
			System.out.println("call4");
			
			
			System.out.println("instructor detail ="+ins);
			
			System.out.println("cal5");
			
			
			session.delete(ins);
			
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
