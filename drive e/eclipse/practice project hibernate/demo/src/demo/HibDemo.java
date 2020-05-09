package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibDemo {
	public static void main(String[] args) {
		System.out.println("call");
		Address address = new Address();
		address.setTown("khetri");
		address.setCity("jhubjhunu");
		address.setPincode(332746+"");
		
		User user = new User(1, "Rakesh",address);
		
		Configuration config = new Configuration().configure("hib.cfg.xml").addAnnotatedClass(User.class);
		
		SessionFactory sf =  config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(user);
//		user = (User)session.get(User.class, 5);
		
		tx.commit();
		
		System.out.println(user);
	}

}
 