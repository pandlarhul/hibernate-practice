package com.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.CPU;
import com.luv2code.hibernate.demo.entity.Laptop;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateLaptopDemo {

	public static void main(String[] args) throws ParseException {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Laptop.class).addAnnotatedClass(CPU.class)
							.buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();
		

			// begin transaction
			session.beginTransaction();

			
			
			Laptop dell = new Laptop("dell", "di57gen");
			Laptop lenovo = new Laptop("lenovo", "ideapad");
			Laptop lenovo2 = new Laptop("lenovo","thinkpad");
			Laptop compaq = new Laptop("hp","persariocq42");
						
			
			// save object
//			session.save(dell);
//			session.save(lenovo);
//			session.save(lenovo2);
			
			
			
			CPU intelCpu = new CPU("dual core","1.3ghz");
			
			CPU snapdragon = new CPU("4 core","1ghz");
			
			snapdragon.setLaptop(lenovo2);
			
			session.save(snapdragon);

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
