package com.training.service;
import java.util.*;
import com.training.dao.UserServiceDao;
public class UserService {
	private Scanner sc;
	private UserServiceDao userdao;
	
	
	public UserService()
	{
		sc=new Scanner(System.in);
		userdao=new UserServiceDao();
	}
	
	public void userloginvalidation()
	{
		System.out.println("Enter the name for validation");
		String name=sc.next();
		System.out.println("Enter the password pls..");
		String psswd=sc.next();
		userdao.userloginvalidationdao(name,psswd);
	}
	public void userregistration()
	{
		userdao.userregistrationdao();
	}
}
