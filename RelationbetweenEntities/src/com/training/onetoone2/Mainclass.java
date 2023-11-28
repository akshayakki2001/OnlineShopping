package com.training.onetoone2;
import org.hibernate.*;

import org.hibernate.cfg.*;

import java.util.List;
import java.util.Scanner;
public class Mainclass {
	public SessionFactory sesfact;
	public Session session;
	public Transaction tx;
	public Scanner sc;
	
	public Mainclass()
	{
		sesfact=new Configuration().configure("hiber.cfg.xml").buildSessionFactory();
		sc=new Scanner(System.in);
	}
	public void insert()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter how many product do you want to insert");
		int noof=sc.nextInt();
		for(int i=0;i<noof;i++)
		{
			Product p=new Product();
			
			
			ProductDetails prod=new ProductDetails();
			System.out.println("");
			System.out.println("Enter the unique id of the product");
			p.setProductid(sc.nextInt());
			System.out.println("Enter the name of the product");
			p.setProductname(sc.next());
			System.out.println("Enter the category..");
			p.setCategory(sc.next());
			System.out.println("Enter the name of the Manufacturer");
			prod.setManufacturer(sc.next());
			System.out.println("Enter the date of manufacturer");
			prod.setDateofmanufacture(sc.next());
			System.out.println("Enter the date of expire..");
			prod.setDateofexpire(sc.next());
			p.setProdobj(prod);
			prod.setPobj(p);
			session.save(p);
		}
		System.out.println("Data inserted");
		tx.commit();
	}
	public void retrieve()
	{
		session=sesfact.openSession();
		//ProductDetails p=new ProductDetails();
		org.hibernate.query.Query q=session.createQuery("from Product");
		List<Product> plist=q.list();
		for(Product p:plist)
		{
		System.out.println("the id of the product is "+p.getProductid());
		System.out.println("the name of the product is "+p.getProductname());
		System.out.println("the name of the manufacturer"+p.getProdobj().getDateofmanufacture());
		
		System.out.println("the manufacture date is "+p.getProdobj().getDateofmanufacture());
		}
	}
	public void delete()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter the id of the product to be deleted");
		int id=sc.nextInt();
		Product pobj=session.find(Product.class,id);
		if(pobj!=null)
		{
			session.delete(pobj);
			System.out.println("Data Deleted...");
			tx.commit();
		}
		else
		{
			System.out.println("No Record Found..");
		}
	}
	public void update()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter the id of the Product to be updated..");
		int id=sc.nextInt();
		//Product product=session.get(Product.class,id);
		//ProductDetails prod=session.get(ProductDetails.class,id);
		//Query<Product> q=session.createQuery("select s from Product s innerjoin s.prodobj");
	   Product pobj=session.find(Product.class, id);
	    if(pobj!=null)
	    {
	    	System.out.println("Enter the new name of the product...");
			String name=sc.next();
			System.out.println("Enter the new manufacturer name");
			String manname=sc.next();
	    	pobj.setProductname(name);
	    	System.out.println("Name Updated..");
	    	System.out.println();
	    	pobj.getProdobj().setManufacturer(manname);
	    	System.out.println(" Manufacturer Name Updated...");
	    	tx.commit();
	    }
	    else
	    {
	    	System.out.println("No Id found..");
	    }
		
	}
	public static void main(String[] args) {
		Mainclass mainobj=new Mainclass();
		//mainobj.insert();
		//mainobj.retrieve();
		//mainobj.delete();
		mainobj.update();
	}

}
