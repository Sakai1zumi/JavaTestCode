package com.oop.exer;

/*
定义类KidsTest，在类的main方法中实例化Kids的对象someKid用该对象访问其父类的成员变量和方法
 */

public class KidsTest {

    public static void main(String[] args) {

        Kids someKid = new Kids(3);

        someKid.printAge();
        someKid.setSalary(0);
        someKid.setSex(1);

        someKid.manOrWoman();
        someKid.employeed();
    }
}
