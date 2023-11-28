package com.training.onetomany;
import java.util.*;
public class Department {
	private int deptcode;
	public int getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(int deptcode) {
		this.deptcode = deptcode;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(Set<Employee> emplist) {
		this.emplist = emplist;
	}
	private String deptname;
	private String city;
	private Set<Employee> emplist;
	

}


