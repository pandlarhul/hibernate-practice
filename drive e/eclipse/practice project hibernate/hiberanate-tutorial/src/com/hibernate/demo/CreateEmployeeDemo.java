package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	
	public static void saveNewEmployee(Employee newEmployee) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(newEmployee.getClass()).buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();
//
//			// create student class
//			Employee student = new Employee();
//			student.setCompanyName("goma");
//			student.setFirstName("John");
//			student.setLastName("paul");
//			//student.setId(1);

			// begin transcation
			session.beginTransaction();

			// save object
			session.save(newEmployee);

			// commit save
			session.getTransaction().commit();
			
			session.close();
		} finally {
			sessionFactory.close();
		}

	}

}
