package com.kanakM.UMS.modal;

public class User {

    private int userId;
    private String Name;
    private String userName;
    private String Address;
    private long PhoneNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

}
