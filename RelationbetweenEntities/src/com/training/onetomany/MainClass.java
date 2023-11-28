package com.training.onetomany;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class MainClass {

	    private Session ses;
	    private SessionFactory sf;
	    private Transaction tx;
	    
	    public MainClass()
	    {
	        sf=new Configuration().configure("onetomany.cfg.xml").buildSessionFactory();
	    }
	    
	    public void insert()
	    {
	        ses=sf.openSession();
	        tx=ses.beginTransaction();
	        
	        Department dept1=new Department();
	        //dept1.setDeptcode(1);
	        dept1.setDeptname("Manager");
	        
	       // Department dept2=new Department();
	        //dept2.setDeptcode(2);
	       // dept2.setDeptname("HR");
	        
	        Employee emp1=new Employee();
	        //emp1.setEmpid(3);
	        emp1.setEmpname("Sana");
	        emp1.setSalary(40000);
	        emp1.setDeptobj(dept1);
	        
	        Employee emp2=new Employee();
	        //emp2.setEmpid(4);
	        emp2.setEmpname("Abhi");
	        emp2.setSalary(90000);
	        emp2.setDeptobj(dept1);
	        
	        Set<Employee>empset1=new HashSet<Employee>();
	        empset1.add(emp1);
	        dept1.setEmplist(empset1);
	        ses.save(dept1);
	        
	        Set<Employee>empset=new HashSet<Employee>();
	        empset.add(emp2);
	       // dept2.setEmplist(empset);
	        //ses.save(dept2);
	        
	        System.out.println("Data Inserted");
	        
	        ses.getTransaction().commit();
	        ses.close();
	    }
	    
	    
	    public void fetch()
	    {
	        ses=sf.openSession();
	        tx=ses.beginTransaction();
	        
	        Department de=ses.find(Department.class, 1);
	         Set<Employee> eset=de.getEmplist();
	         for(Employee e:eset)
	         {
	             System.out.println("");
	         }
	    }
	    
	    public static void main(String[] args) {
	        
	        MainClass m=new MainClass();
	        m.insert();
	    }
	}
