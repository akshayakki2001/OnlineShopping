package com.training.entities;

public class Item {

    private int itemid;
    public int getItemid() {
        return itemid;
    }
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    
    private String category;
    private double buyingPrice;
    
    public String getCategory() {
        return category;
    }
    public double getBuyingPrice() {
        return buyingPrice;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    
}


