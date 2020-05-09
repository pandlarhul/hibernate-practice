package com.hibernate.demo;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployee {

	@SuppressWarnings("unchecked")
	public static Employee get(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Employee emp;
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

						// begin transcation
			session.beginTransaction();

			emp = session.get(Employee.class, id);
			
			// commit save
			session.getTransaction().commit();

			session.close();
		} finally {
			sessionFactory.close();
		}
		return emp;

	}

}
