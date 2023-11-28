package com.training.onetomany;

public class Employee {
	private int empid;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDeptobj() {
		return deptobj;
	}
	public void setDeptobj(Department deptobj) {
		this.deptobj = deptobj;
	}
	private String empname;
	private double salary;
	private Department deptobj;

}


