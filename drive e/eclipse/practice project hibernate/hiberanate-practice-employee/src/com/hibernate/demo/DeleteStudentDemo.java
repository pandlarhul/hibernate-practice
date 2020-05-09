package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
			try {
				Session session  = factory.getCurrentSession();
				
				session.beginTransaction();
				
//				Student st = session.get(Student.class, 1);
//				
//				session.delete(st);
//
				
				session.createQuery("delete from Student where id = 3");
				
				session.getTransaction().commit();
				
				session.close();
			} finally {
				factory.close();
							}

	}

}
