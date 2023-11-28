package com.training.entities;

public class Product extends Item{

    
    private String productName;
    private double sellingPrice;
    private int availableQuantity;
    public User getUserobj() {
        return userobj;
    }
    public void setUserobj(User userobj) {
        this.userobj = userobj;
    }
    private User userobj;
    
    
    
    public String getProductName() {
        return productName;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}