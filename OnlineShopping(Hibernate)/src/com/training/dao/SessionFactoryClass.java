package com.training.dao;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class SessionFactoryClass {
	private static SessionFactory sesfact;

	private SessionFactoryClass()
	{
		sesfact=new Configuration().configure("onlinestore.cfg.xml").buildSessionFactory();
	}
	public static SessionFactory getSessionFactory()
	{
		if(sesfact != null)
		{
			return sesfact;
		}
		else
		{
			SessionFactoryClass sesobj=new SessionFactoryClass();
			return sesfact;
		}
		
	}
	
}
