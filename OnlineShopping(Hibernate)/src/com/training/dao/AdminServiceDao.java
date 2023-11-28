package com.training.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.entities.Item;
import com.training.entities.Product;
import com.training.entities.User;

public class AdminServiceDao {
	private Scanner sc;
	private SessionFactory sesfact;
	private Session session;
	private Transaction tx;
	public AdminServiceDao()
	{
		sc=new Scanner(System.in);
		sesfact=sesfact=SessionFactoryClass.getSessionFactory();
	}
	
	public void adminchoice(User userobj)
	{
		boolean ch=true;
		while(ch)
		{
		System.out.println("Enter 1 for inserting Data..");
		System.out.println("Enter 2 for Searching an product using productid..");
		System.out.println("Enter 3 for Searching an product by Category..");
		System.out.println("Enter 4 for to check total amount spend till now...");
		System.out.println("Enter 5 for to calculate profit by category..");
		System.out.println("Enter 6 for exit..");
		System.out.println();
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			insertdata(userobj);
			break;
		case 2:
			searchUsingProductid();
			break;
		case 3:
			searchByCategory();
			break;
		case 4:
			totalamountSpend();
			break;
		case 5:
			profitbyCategory();
			break;
		case 6:
			System.exit(0);
		}
		}
	}
	public void insertdata(User userobj)
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter how many products do you want to add..");
		int noof=sc.nextInt();
		for(int i=0;i<noof;i++)
		{
		  Product p=new Product();
		 // Item iobj=new Item();
		System.out.println("Enter the product id..");
		int id=sc.nextInt();
		System.out.println("Enter the name of the product...");
		String name=sc.next();
		System.out.println("Enter the category..");
		String cat=sc.next();
		System.out.println("Enter the buying price");
		double bprice=sc.nextDouble();
		System.out.println("AvailableQuantity");
		int availquant=sc.nextInt();
		p.setSellingPrice(bprice+(bprice*0.5));
		p.setItemid(id);
		p.setProductName(name);
		p.setCategory(cat);
		p.setBuyingPrice(bprice);
		p.setAvailableQuantity(availquant);
		p.setUserobj(userobj);
		session.save(p);
		}
		tx.commit();
	}
	public void searchUsingProductid()
	{
		session=sesfact.openSession();
		System.out.println("Enter the id of the product to search");
		int id=sc.nextInt();
		Query q=session.createQuery("select p from Product p where p.itemid=:id");
		q.setParameter("id",id);
		List<Product> plist=q.list();
		if(!plist.isEmpty())// checking whether the list is empty or not 
		{
			for(Product p:plist)
			{
				System.out.println("The name of the Product is "+p.getProductName());
				System.out.println("The category of the Product is "+p.getCategory());
				System.out.println("The buying price is "+p.getBuyingPrice());
				System.out.println("The selling price is "+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
			}
		}
		else
		{
			System.out.println("There is no Product with this id...");
		}
	}
	
	
	public void searchByCategory()
	{
		session=sesfact.openSession();
		System.out.println("Enter the category of the product to search");
		String cat=sc.next();
		Query q=session.createQuery("select p from Product p where p.category=:cat");
		q.setParameter("cat",cat);
		List<Product> plist=q.list();
		if(!plist.isEmpty())// checking whether the list is empty or not 
		{
			for(Product p:plist)
			{
				System.out.println("The name of the Product is "+p.getProductName());
				System.out.println("The category of the Product is "+p.getCategory());
				System.out.println("The buying price is "+p.getBuyingPrice());
				System.out.println("The selling price is"+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
				System.out.println();
			}
		}
		else
		{
			System.out.println("There is no Product with this Category...");
		}
	}
	
	
	public void searchByName()
	{
		session=sesfact.openSession();
		System.out.println("Enter the name of the product to search");
		String name=sc.next();
		Query q=session.createQuery("select p from Product p where p.productName=:cat");
		q.setParameter("cat",name);
		List<Product> plist=q.list();
		if(!plist.isEmpty())// checking whether the list is empty or not 
		{
			for(Product p:plist)
			{
				System.out.println("The Product id is "+p.getItemid());
				System.out.println("The name of the Product is "+p.getProductName());
				System.out.println("The category of the Product is "+p.getCategory());
				System.out.println("The buying price is "+p.getBuyingPrice());
				System.out.println("The selling price is"+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
				System.out.println();
			}
		}
		else
		{
			System.out.println("There is no Product with this Name...");
		}
	}
	
	
	public void totalamountSpend()
	{
		session=sesfact.openSession();
		Query<Double> q=session.createQuery("select sum(p.buyingPrice) from Product p");
		Double total=q.uniqueResult();
		System.out.println("The total amount spend is.."+total);
		System.out.println();
		// here "Double" is ther generics where we want a data of that particular type 
		// that is double type which is returned by the sesion.createQuery
	}
	
	
	public void profitbyCategory()
	{
		session=sesfact.openSession();
		System.out.println("Enter the category name..");
		String cat=sc.next();
		double profit=0;
		Query q=session.createQuery("select p from Product p where p.category=:cat");
		q.setParameter("cat",cat);
		List<Product> plist=q.list();
		for(Product p:plist)
		{
			profit=profit+(p.getSellingPrice()-p.getBuyingPrice());
		}
		if(profit>0)
		{
			System.out.println("Profit gained with this category of product is "+profit);
			System.out.println();
		}
		else
		{
			System.out.println("no category found..");
		}
	}

}
