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

5. 抽象类的匿名子类
 */

public class AbstractTest {

    public static void main(String[] args) {

//        一旦Person类声明为abstract，不能实例化
//        Person p1= new Person();
//        p1.eat();

        method(new Student());//匿名对象

        method1(new Student());//非匿名的类的匿名的对象

        //创建了一匿名子类的的对象，p
        Person p = new Person(){

            @Override
            public void breathe() {
                System.out.println("p呼吸");
            }

            @Override
            public void show() {
                System.out.println("p是人");
            }

            @Override
            public void eat() {
                System.out.println("p吃饭");
            }

            @Override
            public void walk() {
                System.out.println("p走路");
            }
        };

        method1(p);

        //创建匿名子类的匿名对象
        method1(new Person() {
            @Override
            public void show() {
                System.out.println("匿名子类的匿名对象是人");
            }

            @Override
            public void breathe() {
                System.out.println("匿名子类的匿名对象呼吸");
            }

            @Override
            public void eat() {
                System.out.println("匿名子类的匿名对象吃饭");
            }

            @Override
            public void walk() {
                System.out.println("匿名子类的匿名对象走路");
            }
        });

    }

    public static void method(Student s){

    }

    public static void method1(Person p){
        p.eat();
        p.walk();
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

    public Student() {
    }

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

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }

    @Override
    public void walk() {
        System.out.println("学生走路");
    }
}