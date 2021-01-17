package com.oop.demo08.exer;

/*
编写一个类实现银行账户的概念，包含属性有“帐号”、密码”、“存款余额“、”利率“、”最小余额”，定义封装这些属性的方法。
账号要自动生成。
编写主类，使用银行账户输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static 属性。
 */

public class AccountTest {

    public static void main(String[] args) {

        Account acc1 = new Account();
        Account acc2 = new Account("qwerty",2000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(acc1);
        System.out.println(acc2);

    }
}

class Account{

    private int id;
    private String passWord = "000000";
    private double balance;

    public Account(){
        id = init++;
    }

    public Account(String passWord,double balance){
        this();
        this.passWord = passWord;
        this.balance = balance;
    }

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;//自动生成id

    public int getId() {
        return id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", passWord='" + passWord + '\'' +
                ", balance=" + balance +
                '}';
    }
}
