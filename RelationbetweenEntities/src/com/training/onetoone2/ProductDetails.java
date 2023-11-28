package com.training.onetoone2;

public class ProductDetails {
	private int productid;
	private String manufacturer;
	private String dateofmanufacture;
	private String dateofexpire;
	private Product pobj;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDateofmanufacture() {
		return dateofmanufacture;
	}
	public void setDateofmanufacture(String dateofmanufacture) {
		this.dateofmanufacture = dateofmanufacture;
	}
	public String getDateofexpire() {
		return dateofexpire;
	}
	public void setDateofexpire(String dateofexpire) {
		this.dateofexpire = dateofexpire;
	}
	public Product getPobj() {
		return pobj;
	}
	public void setPobj(Product pobj) {
		this.pobj = pobj;
	}

}
