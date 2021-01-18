package com.oop.demo09.ovreridetest;

public class Student extends Person{

    String major;

    public Student(){

    }

    public Student(String major){
        this.major = major;
    }

    public void study(){
        System.out.println("学习，专业是：" + major);
    }

    //对父类中的eat方法进行了重写
//    public void eat(){
//        System.out.println("学生应该多吃饭");
//    }

    @Override
    public void eat() {
        System.out.println("学生应该多吃饭");
    }

    //子类不能重写父类中声明为private权限的方法
    public void show(){
        System.out.println("我是一个学生");
    }

    //父类被重写的方法返回值如果为A类型,则子类重写的方法可以为A类型或者A的子类
    public String info(){
        return null;
    }
}
