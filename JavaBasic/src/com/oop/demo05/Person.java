package com.oop.demo05;

//在Java中，所有的类都默认直接或者间接继承java.lang.Object类
//Person类：父类
public class Person {

    //public
    //protected
    //缺省（default）
    //private
    //四种权限都可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
    //修饰类只能使用缺省或者public

    //快捷键：Ctrl + h


    public Person() {
        System.out.println("Person无参构造器");
    }

    //私有属性同样会被继承，需通过get和set调用
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
