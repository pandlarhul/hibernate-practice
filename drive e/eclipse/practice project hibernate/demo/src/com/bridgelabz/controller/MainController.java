package com.bridgelabz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainController {
	public static void main(String[] args) {
		
		// for laptop 
		List<Laptop> laptop = new ArrayList<Laptop>();
		
		Laptop l1 = new Laptop();
		
		l1.setLid(111);
		l1.setName("dell");
		laptop.add(l1);
		
		l1 = new Laptop();
		l1.setLid(111);
		l1.setName("dell");
		l1.setMfcDate(new Date());
		l1.setModelName("d-19");
		l1.setOk(true);
		laptop.add(l1);
		
		
		// for student
//		Student st = new Student();
//		st.setId(103);
//		st.setName("sizuka");
//		st.setLaptop(laptop);
		
		// configure the hib.cfg.xml file
		Configuration config = new Configuration().configure("hib.cfg.xml").addAnnotatedClass(Laptop.class);//addAnnotatedClass(Student.class);
		
		// build session factory
		SessionFactory sf = config.buildSessionFactory();
		
		// open new session
		Session session = sf.openSession();
		
		// begin transcation
		Transaction tx = session.beginTransaction();
		
		//st = session.get(Student.class, 101);
		
		session.save(l1);
		//session.save(st);
		//session.save(laptop);
		
		//System.out.println("id="+st.getId()+"\nname ="+"hi "+st.getName());
		
		tx.commit();
		
	}

}
