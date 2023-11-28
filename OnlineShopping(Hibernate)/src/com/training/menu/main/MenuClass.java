package com.training.menu.main;

import java.util.Scanner;

//import com.training.dao.UserServiceDao;
import com.training.service.UserService;

public class MenuClass {
	
	private Scanner sc;
	private UserService userserviceobj;
	public MenuClass()
	{
		sc=new Scanner(System.in);
		userserviceobj=new UserService();
	}

	public void menu()
	{  
		boolean ch=true;
		while(ch)
		{
		System.out.println("");
		System.out.println("Enter 1 for Login...");
		System.out.println("Enter 2 for Register as an New User...");
		System.out.println("Enter 3 for exit,,");
		
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			userserviceobj.userloginvalidation();
			break;
		case 2:
			userserviceobj.userregistration();
		case 3:
			System.exit(0);
		}
		
	}
	}
}
