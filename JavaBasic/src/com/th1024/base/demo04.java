package com.th1024.base;

public class demo04 {
    //常量  final 常量名 = 值
    static final double PI = 3.14;

    //类变量  static
    static double salary = 2500;

    //属性：变量

    //实例变量,从属于对象
    //如果不自行初始化，类型默认值 0  0.0
    //布尔值默认值为false
    //除了基本类型，其余默认值都是null
    String name;
    int age;

    //main方法
    public static void main(String[] args) {
        //局部变量，必须声明和初始化值
        int i =10;
        System.out.println(i);

        //变量类型  变量名字 = new demo08（）
        demo04 Demo04 = new demo04();
        System.out.println(Demo04.age);
        System.out.println(Demo04.name);

        //类变量
        System.out.println(salary);

        //常量
        System.out.println(PI);
    }

    //其他方法
    public void add(){

    }
}
