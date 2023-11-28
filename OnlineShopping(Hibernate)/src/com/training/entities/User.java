package com.training.entities;
import java.util.Set;

public class User {
    
    private int userid;
    private String username;
    private String emailid;
    private String password;
    private int superCoins;
    private String userType;
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    private Set<Product> setptoduct;
    
    public int getUserid() {
        return userid;
    }
    public Set<Product> getSetptoduct() {
        return setptoduct;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public void setSetptoduct(Set<Product> setptoduct) {
        this.setptoduct = setptoduct;
    }
    
    public String getUsername() {
        return username;
    }
    public String getEmailid() {
        return emailid;
    }
    public String getPassword() {
        return password;
    }
    public int getSuperCoins() {
        return superCoins;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }
}
