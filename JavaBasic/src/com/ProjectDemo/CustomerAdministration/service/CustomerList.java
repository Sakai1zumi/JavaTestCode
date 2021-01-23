package com.ProjectDemo.CustomerAdministration.service;

import com.ProjectDemo.CustomerAdministration.bean.Customer;

/*
CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
并提供相应的添加、修改、删除和遍历方法供Customer调用
 */
public class CustomerList {

    private Customer[] customers; //用来保存客户对象的数组
    private int total = 0; //记录已经保存客户对象的数量

    //初始化数组的构造器
    public CustomerList(int totalCustomers){
        customers = new Customer[totalCustomers];
    }

    //将指定的客户添加到数组中
    public boolean addCustomers(Customer customer){
        if(total >= customers.length){
            return false;//添加失败
        }

        customers[total] = customer;
        total++;

        return true;
    }

    //修改指定索引位置的客户信息
    public boolean replaceCustomer(int index, Customer customer){

        if (index < 0 || index >= total){
            return false;
        }

        customers[index] = customer;

        return true;
    }

    //删除指定索引位置的客户信息
    public boolean deleteCustomer(int index){

        if (index < 0 || index >= total){
            return false;
        }

        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i+1];
        }
        //最后有数据的元素需要置空
//        customers[total - 1] = null;
//        total--;
        //或者
        customers[--total] = null;
        return true;
    }

    //获取所有的客户信息
    public Customer[] getAllCustomers(){

        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }

        return custs;
    }

    //获取指定索引位置上的客户
    public Customer getCustomer(int index){

        if(index < 0 || index >= total){
            return null;
        }

        return customers[index];
    }

    //获取存储的客户的数量
    public int getTotal(){
        return total;
    }
}
