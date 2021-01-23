package com.oop.demo02;

public class Bank {

    private Customer[] customers;//存放多个客户的数组
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10];//构造器中初始化
    }

    //添加客户
    public void addCustomer(String firstName,String lastName){
        Customer cust = new Customer(firstName,lastName);
        customers[numberOfCustomers] = cust;
        numberOfCustomers++;
    }

    //获取客户个数
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    //获取指定位置的客户
    public Customer getCustomers(int index) {
        //return customers[index];//可能报异常

        if(index >= 0 && index < numberOfCustomers){
            return customers[index];
        }

        return null;
    }
}
