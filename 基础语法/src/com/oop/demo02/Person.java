package com.oop.demo02;

public class Person {
    //一个类即使什么都不写，它也会存在一个方法
    //显示定义构造器

    String name;
    int age;

    //实例化一些对象
    //1.使用new关键字，本质是在调用构造器
    //2.用来初始化值
    public Person(){
        this.name = "tuhong";
    }

    //有参构造：一旦定义了有参构造，无参构造就必须显式定义
    public Person(String name){
        this.name = name;
    }

    //alt+insert：快捷生成构造器等

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }


}

/*
public class Application {
    public static void main(String[] args) {

        //new 实例化了一个对象
        Person person0 = new Person();
        Person person1 = new Person("涂鸿",23);

        System.out.println(person0.name);
        System.out.println(person1.name+" "+person1.age);

    }
}

 */
