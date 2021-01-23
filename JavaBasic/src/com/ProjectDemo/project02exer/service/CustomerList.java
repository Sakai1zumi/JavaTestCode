package com.ProjectDemo.project02exer.service;

import com.ProjectDemo.project02exer.bean.Customer;

/*
CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
并提供相应的添加、修改、删除和遍历方法供Customer调用
 */

public class CustomerList {

    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomers){

        customers = new Customer[totalCustomers];

    }

    public boolean addCustomer(Customer customer){

        if(total < customers.length){
            customers[total] = customer;
            total++;
            return true;
        }else{
            return false;
        }

    }

    public boolean replaceCustomer(int index,Customer cust){

        if(index < total && index >= 0){
            customers[index] = cust;
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteCustomer(int index){

        if(index < total && index >= 0){
            for(int i = index;i < total - 1;i++){
                customers[i] = customers[i+1];
            }
            customers[total - 1] = null;
            total--;
            return true;
        }else{
            return false;
        }

    }

    public Customer[] getAllCustomers(){

        Customer[] custs = new Customer[total];

        for(int i = 0;i < total;i++){
            custs[i] = customers[i];
        }

        return custs;

    }

    public Customer getCustomer(int index){

        Customer cust = new Customer();

        if(index < total && index >= 0){
            cust = customers[index];
            return cust;
        }else{
            return null;
        }

    }

    public int getTotal(){
        return total;
    }
}
