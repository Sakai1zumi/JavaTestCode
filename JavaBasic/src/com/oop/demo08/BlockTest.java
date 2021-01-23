package com.oop.demo08;

/*
类的成员之四：代码块（或初始化块）

1. 代码块的作用：通常用来初始化类、对象

2. 代码块只能使用static修饰或者无修饰符

3. 分类：静态代码块 vs 非静态代码块

4. 静态代码块
    >内部可以有输出语句
    >随着类的加载而执行，且只执行一次
    >作用：初始化类的信息
    >静态代码块内只能调用静态的属性和静态的方法，不能调用非静态结构

   非静态代码块
   >内部可以有输出语句
   >随着对象的创建而执行，每创建一个对象就执行一次非静态代码块
   >作用：可以在创建对象时，对对象的属性等进行初始化
   >非静态代码块可以调用静态的属性和静态的方法，或非静态的属性和非静态的方法
5. 执行顺序：由父及子，静态先行

6. 对属性可以赋值的位置：
    ①默认初始化
    ②显式初始化
    ③构造器中初始化
    ④”对象.属性“或“对象.方法”赋值
    ⑤代码块中赋值

    执行先后顺序：① - ②/⑤ - ③ - ④
 */

public class BlockTest {

    public static void main(String[] args) {

        String desc = Person1.desc;
        System.out.println(desc);

        Person1 person1 = new Person1();
        Person1 person2 = new Person1();

        System.out.println(person1.age);
        System.out.println(person2.age);

    }
}

class Person1{

    //属性
    String name;
    int age;
    static String desc = "我是一个人";

    //构造器
    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //static代码块
    static{
        System.out.println("Hello,static block");
        desc = "我是一个爱学习的人";
    }

    //非static代码块
    {
        System.out.println("Hello,block");
        age = 1;
    }

    //方法
    public void eat(){
        System.out.println("吃饭");
    }

    public static void info(){
        System.out.println("我是一个快乐的人");
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
