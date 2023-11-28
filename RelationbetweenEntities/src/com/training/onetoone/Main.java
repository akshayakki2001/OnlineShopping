package com.training.onetoone;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {
	
	private SessionFactory sesfact;
	private Session session;
	private Transaction tx;
	
	public Main()
	{
		sesfact= new Configuration().configure("hiber.cfg.xml").buildSessionFactory();
	}
	public void insert()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		Student s1=new Student();
		//s1.setStudentid(1);
		s1.setStudentname("Akshay");
		s1.setScore(98);
		Address adobj=new Address();
		adobj.setHouseno(219);
		adobj.setCity("Delhi");
		adobj.setState("Delhi");
		s1.setAddobj(adobj);
		adobj.setStobj(s1);
		session.save(s1);
		tx.commit();
		System.out.println("Data Saved...");
	}
	public void retrievejoin()
	{
		session=sesfact.openSession();
		Query q=session.createQuery("select s.studentname,s.score,a.houseno,a.city,a.state from Student s join Address a on s.studentid=a.addid");
		
		List<Object[]> stlist=q.list();
		for(Object[] s:stlist)
		{
			System.out.println("Student name is "+s[0]);
			System.out.println("Student score is "+s[1]);
			System.out.println("Student house number is "+s[2]);
			System.out.println("Student city is "+s[3]);
			System.out.println("Student State is "+s[4]);
		}
	}
	public static void main(String[] args) {
		Main mainobj=new Main();
		//mainobj.insert();
		mainobj.retrievejoin();
	}

}
