package com.training.onetomany2;

import java.util.Set;

public class Customer {
	
	private String cusid;
	private String cusname;
	private String cusphone;
	private String address;
	private Set<Item> itemlist;
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCusphone() {
		return cusphone;
	}
	public void setCusphone(String cusphone) {
		this.cusphone = cusphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(Set<Item> itemlist) {
		this.itemlist = itemlist;
	}

}
