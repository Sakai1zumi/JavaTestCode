package com.oop.demo05;

public class Application {

    public static void main(String[] args) {

        Person person = new Person();
        Student student = new Student();

        person.setAge(50);
        student.setAge(20);

        //System.out.println(student.getMoney());
        System.out.println(person.getAge());
        System.out.println(student.getAge());
    }
}
