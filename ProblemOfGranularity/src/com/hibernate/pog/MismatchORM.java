package com.hibernate.pog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MismatchORM 
{
	public static void main(String[] args) 
	{
		System.out.println("This example will solve the mismatch problem of ORM");
		
		Person p = new Person();
		p.setId(110);
		p.setName("Jaden smith");
		
		Address permanentAddr = new Address();
		permanentAddr.setStreet("wall street");
		permanentAddr.setCity("NewYork");
		permanentAddr.setState("NY");
		permanentAddr.setCountry("USA");
		
		Address currentAddr = new Address();
		currentAddr.setStreet("curacavi");
		currentAddr.setCity("Santiago");
		currentAddr.setState("Santiago");
		currentAddr.setCountry("Chili");	
		
		p.setPermanentAddress(permanentAddr);
		p.setCurrentAddress(currentAddr);
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		// If person not exist then update in database.
		if(session.get(Person.class,110)!=null)
		{
			session.save(p);
			session.getTransaction().commit();
			session.close();
		}
		
		
		Person person =(Person)session.get(Person.class, 110);
		
		System.out.println("Person Id: "+person.getId());
		System.out.println("Person name: "+person.getName());
		System.out.println("Current living city: "+ person.getCurrentAddress().getCity());
		System.out.println("Permanent living Country: "+ person.getPermanentAddress().getCountry());
		
		System.out.println("Successfully updated the person details");
		
	}
}
