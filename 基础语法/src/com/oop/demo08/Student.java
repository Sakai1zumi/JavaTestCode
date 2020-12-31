package com.oop.demo08;

public class Student {

    private static int age;//静态的变量
    private double score;//非静态变量

    public static void go(){

    }

    public void run(){

    }

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.score = 100;

        Student.age = 12;

        s1.run();

        go();
    }
}
