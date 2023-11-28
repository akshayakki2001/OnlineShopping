package com.training.onetoone2;

public class Product {
	private int productid;
	private String productname;
	private String category;
	private ProductDetails prodobj;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProductDetails getProdobj() {
		return prodobj;
	}
	public void setProdobj(ProductDetails prodobj) {
		this.prodobj = prodobj;
	}

}
