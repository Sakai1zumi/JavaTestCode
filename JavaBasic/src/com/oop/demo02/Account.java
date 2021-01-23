package com.oop.demo02;

public class Account {

    private int id;//账号
    private double balance;//余额
    private double annualInterestRate;//年利率


    public Account(int id,double balance,double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("余额不足，取款失败");
            return;
        }
        this.balance -= amount;
        System.out.println("成功取出" + amount+ "元");
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("成功存入" + amount + "元");
        }
    }
}
