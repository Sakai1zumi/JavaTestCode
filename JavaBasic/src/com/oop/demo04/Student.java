package com.oop.demo04;

//类    封装：private--私有
public class Student {
    //属性私有
    private String name;//名字

    private int id;//学号

    private char sex;//性别

    private int age;//年龄

    //提供一些可以操作这个属性的方法
    //public的get，set方法

    //get--获得这个数据
    public String getName(){
        return this.name;
    }

    //set--给这个数据设置值
    public void setName(String name){
        this.name = name;
    }

    //alt + insert
    //生成getter和setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>120 || age<0){//不合法
            System.out.println("非法输入");
        }else{
            this.age = age;
        }

    }
}

//封装
/*
1.提高了程序的安全性，保护数据
2.隐藏代码的实现细节
3.统一接口
4.提高系统可维护性
public class Application {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setName("TuHong");
        System.out.println(s1.getName());

        s1.setAge(999);
        System.out.println(s1.getAge());
    }

 */