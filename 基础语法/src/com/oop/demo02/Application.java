package com.oop.demo02;

import com.oop.demo02.Person;

//一个项目应该只存在一个main方法
public class Application {
    public static void main(String[] args) {

        //new 实例化了一个对象
        Person person0 = new Person();
        Person person1 = new Person("涂鸿",23);

        System.out.println(person0.name);
        System.out.println(person1.name+" "+person1.age);

    }
}
