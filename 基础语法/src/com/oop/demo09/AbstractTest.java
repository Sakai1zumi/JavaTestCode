package com.oop.demo09;

/*
abstract关键字的使用

1. abstract可以用来修饰的结构：类、方法

2. abstract修饰类：抽象类
    >此类不能实例化
    >抽象类中一定有构造器，子类实例化时调用
    >开发中会提供抽象类的子类，利用子类实例化完成操作

3. abstract修饰方法：抽象方法
    >只有方法的声明，没有方法体
    >包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法
    >子类需重写父类中所有抽象方法，方可实例化。若没有重写所有的抽象方法，则子类也声明为abstract

4. abstract使用上的注意点
    4.1 abstract不能用来修饰：属性、构造器等结构
    4.2 abstract不能用来修饰私有方法、静态方法、final的方法和类
 */

public class AbstractTest {

    public static void main(String[] args) {

//        一旦Person类声明为abstract，不能实例化
//        Person p1= new Person();
//        p1.eat();

    }
}

abstract class Creature{
    public abstract void breathe();
}

abstract class Person extends Creature{

    String name;
    int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public abstract void show();

    public void eat(){
        System.out.println("人吃饭");
    }

    public void walk(){
        System.out.println("人走路");
    }

}

class Student extends Person{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void show() {
        System.out.println("我是一个学生");
    }

    @Override
    public void breathe() {
        System.out.println("呼吸新鲜空气");
    }
}