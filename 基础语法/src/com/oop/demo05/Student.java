package com.oop.demo05;

//Student is Person：子类
//子类继承父类，就会拥有父类的全部方法
public class Student extends Person{

    private String name = "涂鸿";

    public Student() {
        //隐藏代码：调用父类无参构造器
        super();//调用父类构造器必须要在子类构造器第一行
        System.out.println("Student无参构造器");
    }

    public void test1(){
        print();//Student
        this.print();//Student
        super.print();//Person
    }

    public void print(){
        System.out.println("Student");
    }

    public void test(String name){
        System.out.println(name);//tuhong
        System.out.println(this.name);//涂鸿
        System.out.println(super.name);//TuHong
    }
}
/*
public static void main(String[] args) {
        Student student = new Student();

        //student.test("tuhong");
        //student.test1();
    }
 */
