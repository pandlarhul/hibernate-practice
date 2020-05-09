package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.CPU;
import com.luv2code.hibernate.demo.entity.Laptop;

public class DeleteDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(CPU.class)
							.addAnnotatedClass(Laptop.class)
							.buildSessionFactory();
		try {
						
			// create session;
			Session session = sessionFactory.getCurrentSession();
			
			// begin transcation
			session.beginTransaction();
			
			Laptop laptop = new Laptop();
			
			laptop = session.get(Laptop.class, 9);
			
			System.out.println(laptop);
			
			laptop.getCpu().setLaptop(null);
			session.delete(laptop);
			
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
