package com.oop.demo02;

public class BankTest {

    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.addCustomer("Jane","Smith");

        //连续操作
        bank.getCustomers(0).setAccount(new Account(1000,2000,0));

        bank.getCustomers(0).getAccount().withdraw(500);

        double balance = bank.getCustomers(0).getAccount().getBalance();
        System.out.println("客户" + bank.getCustomers(0).getLastName() + "的账户余额为：" + balance);

        bank.addCustomer("Trump","Donald");

        System.out.println("银行目前客户个数为：" + bank.getNumberOfCustomers());
    }
}
