package com.oop.demo01;

public class Demo02 {

    //静态方法  static 调用：类名.方法名
    //非静态方法

    public static void main(String[] args) {
        //静态方法调用
        Student.say0();

        //非静态方法调用
        //实例化这个类 new
        //对象类型 对象名 = 对象值;
        Student student = new Student();
        student.say1();
    }
}
