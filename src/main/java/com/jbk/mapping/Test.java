package com.jbk.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jbk.config.HibernateConfiguration;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		
		Session session = sf.openSession();
		
		
		Address address = new Address(12, "nashik", 423101, "MH", "Ind");
		Employee emp = new Employee(101, "Mayur", 4000L, address);
		
		session.save(emp);
	session.beginTransaction().commit();
		
		
		
		
				
	}
	}


