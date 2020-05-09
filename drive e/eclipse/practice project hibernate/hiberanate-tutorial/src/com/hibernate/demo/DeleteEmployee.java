package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void delete(Employee employee, boolean deleteAll) {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(employee.getClass()).buildSessionFactory();
		
			try {
				Session session  = factory.getCurrentSession();
				
				session.beginTransaction();
				
//				Student st = session.get(Student.class, 1);
//				
//				session.delete(st);
//
				
				if(deleteAll == true) {
					session.createQuery("delete from Student ");
				} else {
					session.delete(employee);
				}
				
				
				session.getTransaction().commit();
				
				session.close();
			} finally {
				factory.close();
							}

	}
	
	

}
