package com.training.onetomany2;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Main {

	private SessionFactory sesfact;
	private Session session;
	private Transaction tx;
	private Scanner sc;
	public Main()
	{
		sesfact=new Configuration().configure("onetomany2.cfg.xml").buildSessionFactory();
	}
	
	public void insert()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		
		Customer cus=new Customer();
		cus.setCusid("1001");
		cus.setCusname("Akshay");
		cus.setCusphone("812344657866");
		cus.setAddress("Kerala");
		
		Item item=new Item();
		item.setItemcode("101");
		item.setItemname("biscuit");
		item.setItemprice(12);
		item.setQuantityonhand(49);
		
		Item item1=new Item();
		item1.setItemcode("102");
		item1.setItemname("milk");
		item1.setItemprice(30);
		item1.setQuantityonhand(19);
		
		Set<Item> ilist=new HashSet<Item>();
		ilist.add(item);
		ilist.add(item1);
	
		cus.setItemlist(ilist);
	item.setCusobj(cus);
	item1.setCusobj(cus);
		
		session.save(cus);
		tx.commit();
	}
	public void retrievecustomerdata()
	{
		sc=new Scanner(System.in);
		session=sesfact.openSession();
		//tx=session.beginTransaction();
		System.out.println("Enter the id of the customer to be searched...");
		String id=sc.next();
		Query q=session.createQuery("select e from Customer e where e.id=:id");
		q.setParameter("id",id);
		List<Customer> clist=q.list();
		for(Customer c:clist)
		{
			System.out.println("The name of the customer is "+c.getCusname());
			System.out.println("Adddress is "+c.getAddress());
		}
		
	}
	public void retrieveitemdata()
	{
		sc=new Scanner(System.in);
		session=sesfact.openSession();
		System.out.println("Enter the id of the Item to be searched...");
		String id=sc.next();
		Query q=session.createQuery("select i from Item i where i.id=:id");
		q.setParameter("id",id);
		List<Item> clist=q.list();
		if(clist!=null)
		{
		for(Item c:clist)
		{
			System.out.println("The name of the Item is "+c.getItemname());
			System.out.println("Price is "+c.getItemprice());
		}
		}
		else
		{
			System.out.println("No Record Available..");
		}
	}
	public void retrieve()
	{
		sc=new Scanner(System.in);
		session=sesfact.openSession();
		System.out.println("Enter the id of the customer...");
		String id=sc.next();
		Query q=session.createQuery("select c from Customer c where c.id=:id");
		q.setParameter("id",id);
	    List<Customer> clist=q.list();
	    for(Customer c:clist)
	    {
	    	System.out.println("the name of the customer is "+c.getCusname());
	    	System.out.println("the items he bought is ");
	    	Set<Item> itemlist=c.getItemlist();
	    	for(Item i:itemlist)
	    	{
	    		System.out.println(i.getItemname());
	    		System.out.println(i.getItemprice());
	    	}
	    }
	}
	public static void main(String[] args) {
		Main obj=new Main();
		//obj.insert();
		//obj.retrievecustomerdata();
		//obj.retrieveitemdata();
		obj.retrieve();
	}
	
}
