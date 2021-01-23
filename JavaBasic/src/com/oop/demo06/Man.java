package com.oop.demo06;

public class Man extends Person{

    boolean isSmoking;

    public void makeMoney(){
        System.out.println("男人挣钱");
    }

    public void eat(){
        System.out.println("男人多吃饭");
    }

    @Override
    public void walk() {
        System.out.println("男人霸气走路");
    }
}
