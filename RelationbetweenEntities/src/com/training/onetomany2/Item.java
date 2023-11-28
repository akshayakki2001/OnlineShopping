package com.training.onetomany2;

public class Item {
	private String itemcode;
	private String itemname;
	private double itemprice;
	private double quantityonhand;
	private Customer cusobj;
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getItemprice() {
		return itemprice;
	}
	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}
	public double getQuantityonhand() {
		return quantityonhand;
	}
	public void setQuantityonhand(double quantityonhand) {
		this.quantityonhand = quantityonhand;
	}
	public Customer getCusobj() {
		return cusobj;
	}
	public void setCusobj(Customer cusobj) {
		this.cusobj = cusobj;
	}

}
