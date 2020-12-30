package com.oop.demo02;

//学生类
public class Student {

    //属性：字段
    String name; //默认null
    int age;

    //方法
    public void study(){
        System.out.println("学生在上课");
    }
}

/*
public class Application {
    public static void main(String[] args) {


        //类：抽象的，需要实例化
        //类实例化后会返回一个自己的对象
        //student对象就是一个Student类的具体实例

    Student student = new Student();
    Student xiaoMing = new Student();
    Student xiaoHong = new Student();

        xiaoMing.name = "小明";
                xiaoMing.age = 3;
                System.out.println(xiaoMing.name);
                System.out.println(xiaoMing.age);

                }
                }

 */
