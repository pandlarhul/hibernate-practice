package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadStudentDemo {

	public static List<Employee> read(Employee employee) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(employee.getClass())
				.buildSessionFactory();
		List<Employee> list;

		try {
			Session session = factory.getCurrentSession();

			Employee st = new Employee();
			
			session.beginTransaction();

			// all employee
			list = session.createQuery("from Employee").list();
			
			session.getTransaction().commit();
			
			session.close();
		} finally {
			factory.close();
		}
		return list;

	}

}
