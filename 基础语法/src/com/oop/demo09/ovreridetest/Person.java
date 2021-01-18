package com.oop.demo09.ovreridetest;

public class Person {

    String name;
    int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(double time){
        System.out.println("睡觉，睡了" + time + "小时");
        eat();
        show();
    }

    private void show(){
        System.out.println("我是一个人");
    }

    public Object info(){
        return null;
    }
}
