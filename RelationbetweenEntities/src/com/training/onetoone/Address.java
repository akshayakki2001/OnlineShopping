package com.training.onetoone;

public class Address {
	private Integer addid;
	public Integer getAddid() {
		return addid;
	}
	public void setAddid(Integer addid) {
		this.addid = addid;
	}
	public Integer getHouseno() {
		return houseno;
	}
	public void setHouseno(Integer houseno) {
		this.houseno = houseno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private Integer houseno;
	private String city;
	private String state;
	public Student getStobj() {
		return stobj;
	}
	public void setStobj(Student stobj) {
		this.stobj = stobj;
	}
	private Student stobj;
	

}
