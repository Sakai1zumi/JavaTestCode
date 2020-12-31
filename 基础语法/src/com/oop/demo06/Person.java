package com.oop.demo06;

public class Person {

    public void run(){
        System.out.println("run");
    }


}

/*
public static void main(String[] args) {

        //一个对象的实际类型是确定的
        //Student s1;
        //Person s2;

        //可以指向的类型就不确定了：父类的引用指向了子类

        //Student能调用的方法都是自己的或者继承父类的方法
        Student s1 = new Student();
        //Person 父类型，可以指向子类，但不能调用子类独有的方法
        Person s2 = new Student();
        Object s3 = new Student();

        s1.run();//子类重写了父类的方法，执行子类的方法
        s2.run();

        //对象能执行哪些方法，主要看对象左边的类型
        s1.eat();
        //s2.eat();//不能调用子类独有的方法


    }
 */
