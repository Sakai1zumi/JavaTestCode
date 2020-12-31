package com.oop.demo05;

//在Java中，所有的类都默认直接或者间接继承Object类
//Person类：父类
public class Person {

    //public
    //protected
    //default
    //private

    //快捷键：Ctrl + h


    public Person() {
        System.out.println("Person无参构造器");
    }

    //私有的东西无法被继承
    private int age = 100;

    public void print(){
        System.out.println("Person");
    }

    protected String name = "TuHong";

    private int money = 10_000_000;

    public void say(){
        System.out.println("说一句话");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
