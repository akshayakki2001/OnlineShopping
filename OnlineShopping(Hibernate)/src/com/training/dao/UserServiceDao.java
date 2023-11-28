package com.training.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.training.entities.Product;
import com.training.entities.User;
public class UserServiceDao {
	
	private Session session;
	private SessionFactory sesfact;
	private Transaction tx;
	private Scanner sc;
	private List<Product> prodlist;
	private AdminServiceDao adminserviceobj;
	double total;
    public UserServiceDao()
    {
    	sesfact=SessionFactoryClass.getSessionFactory();
    	sc=new Scanner(System.in);
    	adminserviceobj=new AdminServiceDao();
    	prodlist=new ArrayList<Product>();
    }

	public void userloginvalidationdao(String name, String psswd) {  //checks whether admin or user
	 
		session=sesfact.openSession();
		Query q=session.createQuery("select e from User e where e.username=:name and e.password=:psswd");
		q.setParameter("name",name);
		q.setParameter("psswd",psswd);
		List<User> userobj=q.list();
	    for(User u:userobj)
			{
				if(u.getUserType().equalsIgnoreCase("admin"))
				{
					System.out.println("Welcome,, Logined as an Admin");
					adminserviceobj.adminchoice(u);
					
				}
				else if(u.getUserType().equalsIgnoreCase("user"))
				{
					System.out.println("Welcome,, Logined as an User...");
					userchoice(u);
				}
				else
				{
					System.out.println("Invalid Admin Details...");
				}
			}
			
			
		}
		
	
	 public void userregistrationdao() {
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter the name pls  for Registration..");
		String name=sc.next();
		System.out.println("Enter the password pls..");
	    String psswd=sc.next();
		System.out.println("Enter the email id pls..");
		String email=sc.next();
		User userobj=new User();
		userobj.setUsername(name);
		userobj.setPassword(psswd);
		userobj.setEmailid(email);
		userobj.setUserType("user");
		userobj.setSuperCoins(100);
		session.save(userobj);
		tx.commit();
		System.out.println("Congratulations ...");
		System.out.println("Registerd as a new user...");
		System.out.println("Wow.... You Got !00 super coins ..");
		System.out.println();
		userchoice(userobj);
		System.out.println();
	}
	
	
	public void userchoice(User userobj)
	{
		boolean ch=true;
		while(ch)
		{
		System.out.println("Enter 1 for Display the Products Available..");
		System.out.println("Enter 2 for showing Products filter by price..");
		System.out.println("Enter 3 for Filter by Category you want..");
		System.out.println("Enter 4 for Search Product by Product id");
		System.out.println("Enter 5 for Search Product by Product Name ");
		System.out.println("Enter 6 for Purchase Product..");
		System.out.println("Enter 7 for exit..");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			displayProducts();
			break;
		case 2:
			filterByPrice();
			break;
		case 3:
			filterbycategory();
			break;
		case 4:
			searchbyiduser();
			break;
		case 5:
			searchbynameuser();
			break;
		case 6:
			purchaseProduct(userobj);
			break;
		case 7:
			System.exit(0);
		}
		}
	}
	
	
	public void displayProducts()
	{
		session=sesfact.openSession();
		Query q=session.createQuery("select p from Product p");
		List<Product> plist=q.list();
		if(plist.isEmpty())
		{
			System.out.println("No Products Available to Show..");
		}
		else
		{
			for(Product p:plist)
			{
			System.out.println("The Product id is "+p.getItemid());
			System.out.println("The name of the Product is "+p.getProductName());
			System.out.println("The category of the Product is "+p.getCategory());
			System.out.println("The Price of the Product is "+p.getSellingPrice());
			System.out.println("The Available Quantity is "+p.getAvailableQuantity());
			System.out.println();
			}
		}
	}
	
	
	public void filterByPrice() // display products price from low to high
	{
		session=sesfact.openSession();
		Query q=session.createQuery("select p from Product p ORDER BY p.sellingPrice asc");
		List<Product> plist=q.list();
		if(plist.isEmpty())
		{
			System.out.println("No product Available..");
		}
		else
		{
		   for(Product p:plist)
		   {
			    System.out.println("The Product id is "+p.getItemid());
				System.out.println("The name of the Product is "+p.getProductName());
				System.out.println("The category of the Product is "+p.getCategory());
				System.out.println("The Price of the Product is "+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
				System.out.println();
		   }
		}
	}
	
	
	public void filterbycategory()
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
				System.out.println("The Price of the Product is"+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
				System.out.println();
			}
		}
		else
		{
			System.out.println("There is no Product with this Category...");
		}
	}
	
	
	public void searchbyiduser()
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
				System.out.println("The Price of the Product is "+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
			}
		}
		else
		{
			System.out.println("There is no Product with this id...");
		}
	}
	
	
	public void searchbynameuser()
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
				System.out.println("The Price of the Product is"+p.getSellingPrice());
				System.out.println("The Available Quantity is "+p.getAvailableQuantity());
				System.out.println();
			}
		}
		else
		{
			System.out.println("There is no Product with this Name...");
		}
	}
	
	
	public void purchaseProduct(User userobj)
	{
		session=sesfact.openSession();
		boolean ch=true;
		while(ch)
		{
			displayProducts();
			System.out.println();
			System.out.println();
			System.out.println("Enter 1 for select Product by id ..");
			System.out.println("Enter 2 for select Product by name ..");
			System.out.println("Enter 3 for Finish Purchase..");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				selectProductByIdPurchase();
				break;
			case 2:
				selectProductByNamePurchase();
				break;
			case 3:
				createbill(userobj);
				break;
			}
		}
	}
	
	
	public void selectProductByIdPurchase()
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter the Product id ..");
		int id=sc.nextInt();
		Query q=session.createQuery("select p from Product p where p.itemid=:id");
		q.setParameter("id",id);
		List<Product> plist=q.list();
		if(plist.isEmpty())
		{
			System.out.println("No Product with this id...");
		}
		else
		{
		for(Product p:plist)
		{
			p.setAvailableQuantity(p.getAvailableQuantity()-1); //reducing the amount of quantity of particular product selected
			System.out.println("The Price is "+p.getSellingPrice());
			System.out.println();
			prodlist.add(p); //adding the object of the selected item into prodlist
			session.save(p);
		}
		}
		tx.commit();
		session.close();
	}
	
	
	public void selectProductByNamePurchase()
	{
		
		session=sesfact.openSession();
		tx=session.beginTransaction();
		System.out.println("Enter the Product name ..");
	    String name=sc.next();
		Query q=session.createQuery("select p from Product p where p.productName=:name");
		q.setParameter("name",name);
		List<Product> plist=q.list();
		if(plist.isEmpty())
		{
			System.out.println("No Product with this Name...");
		}
		else
		{
		for(Product p:plist)
		{
			System.out.println("The Price is "+p.getSellingPrice());
			System.out.println();
			//int avail=p.getAvailableQuantity();
			p.setAvailableQuantity(p.getAvailableQuantity()-1); // reducing the quantity of the product 
			prodlist.add(p); //adding the object of the selected item into prodlist
			session.save(p);
		}
		}
		tx.commit();
		session.close();
	}
	
	public void createbill(User userobj)
	{
		session=sesfact.openSession();
		tx=session.beginTransaction();

		for(Product p:prodlist)
		{
			total=total+p.getSellingPrice();
			
		}
		System.out.println();
		System.out.println("The Total Bill is "+total);
		System.out.println();
		System.out.println("The SuperCoins in your Hand is "+userobj.getSuperCoins());
		System.out.println("Do you want to use any Super coins.. if yes type 'yes'..");
		String str=sc.next();
		if(str.equalsIgnoreCase("yes"))
		{
			System.out.println();
			System.out.println("You will get 5 rupees for 100 SuperCoins..");
			System.out.println("Enter how many SuperCoins you need to Use..");
			int supercoin=sc.nextInt();
			if(supercoin>userobj.getSuperCoins())
			{
				System.out.println("Not enough SuperCoins InHand..");
				createbill(userobj);
			}
			else
			{
				double discount=(supercoin/100)*5;
				total=total-discount;
				System.out.println("Amount after Discount is "+total);
				System.out.println("Thank You ...");
				userobj.setSuperCoins(userobj.getSuperCoins()-supercoin);
				session.save(userobj);
				tx.commit();
				session.close();
				System.exit(0);
			}
		}
		else
		{
			System.out.println("The Bill is "+total);
			System.out.println();
			System.out.println("THANK YOU ...");
			System.exit(0);
		}
	}

}
