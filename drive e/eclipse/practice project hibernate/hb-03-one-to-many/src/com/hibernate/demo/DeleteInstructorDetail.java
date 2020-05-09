package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetail {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		Session  session = sessionFactory.getCurrentSession();
;
		try {
		
			
			session.beginTransaction();

			
			InstructorDetail ins = session.get(InstructorDetail.class, 5);
			
			ins.getInstructor().setInstructorDetail(null);
			
			session.delete(ins);
			
			System.out.println("Instructor detail:"+ins);
			
			System.out.println("Instructor "+ins.getInstructor());
			
			
			// commit save
			session.getTransaction().commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally { 
			
			session.close();
			sessionFactory.close();
		}

	}

}
