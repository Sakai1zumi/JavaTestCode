package com.oop.demo08;

import java.util.Objects;

public class Customer {

    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //比较两个对象的实体内容
    //手动实现equals()的重写
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//
//        if(obj instanceof Customer){
//            Customer cust = (Customer) obj;
//            //比较两个对象的每个属性是否相同
////            if(this.age == cust.age && this.name.equals(cust.name)){
////                return true;
////            }else{
////                return false;
////            }
//            //或
//            return this.age == cust.age && this.name.equals(cust.name);
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;//判断是否为同一类的对象
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
