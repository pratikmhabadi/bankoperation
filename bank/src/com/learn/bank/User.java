package com.learn.bank;

public class User {
    private String name;
    private String mobileNo;
    private double balance;
    private int accountNo;

    public User(String name, String mobileNo, double balance, int accountNo) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.balance = balance;
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
