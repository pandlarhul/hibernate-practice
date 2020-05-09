package com.hibernate.demo;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		try {

			// create session;
			Session session = sessionFactory.getCurrentSession();

			List<Student> allStudent = new LinkedList<Student>();

			// begin transcation
			session.beginTransaction();

			allStudent = session.createQuery("from Student").list();
			displayStudents(allStudent);

			System.out.println("student with last name = allen");

			allStudent = session.createQuery("from Student s where s.lastName='allen'").getResultList();

			displayStudents(allStudent);

			allStudent = session.createQuery("from Student s where s.firstName='john' or s.lastName='daffy'")
					.getResultList();
			displayStudents(allStudent);

			System.out.println("all student with gmail ending");
			allStudent = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			displayStudents(allStudent);
			
			// commit save
			session.getTransaction().commit();

			session.close();
		} finally {
			sessionFactory.close();
		}

	}

	public static void displayStudents(List<Student> allStudent) {
		for (Student st : allStudent) {
			System.out.println(st);
		}

	}

}
