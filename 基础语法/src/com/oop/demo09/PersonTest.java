package com.oop.demo09;

public class PersonTest {

    public static void main(String[] args) {

        Student s = new Student("计算机科学与技术");

        //方法重写后,子类对象实际执行为子类重写的方法
        s.eat();
        System.out.println("=================");
        s.sleep(7.0);

        s.study();
    }
}
