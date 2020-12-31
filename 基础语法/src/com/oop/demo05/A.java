package com.oop.demo05;

public class A extends B{
    //继承关系
    public static void test(){
        System.out.println("A=>test");
    }

    //重写
    @Override //注解：有功能的注释
    public void test1() {
        System.out.println("A=>test1");
    }
}
/*
public static void main(String[] args) {

        //方法的调用只和左边，定义的数据类型有关
        A a = new A();
        a.test();//A

        //父类的引用指向了子类
        B b = new A();
        b.test();//B

        System.out.println("=======================");
        //静态方法和非静态方法存在差别

        //静态方法是类的方法，而非静态方法是对象的方法
        //即b1是A new出来的对象，因此调用了A方法

        A a1 = new A();
        a1.test1();

        B b1 = new A();//子类重写了父类的方法
        b1.test1();

    }
 */
