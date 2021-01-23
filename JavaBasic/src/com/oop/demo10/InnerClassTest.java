package com.oop.demo10;

/*
类的内部成员之五：内部类

1. Java中允许将一个类A生命在另一个类B中，则类A就是内部类，类B成为外部类

2. 内部类的分类：成员内部类（静态、非静态） vs 局部内部类（方法内、代码块内、构造器内）

3. 成员内部类：
    一方面，作为外部类的成员：
        >调用外部类的结构
        >可以被static修饰
        >可以被4种不同的权限修饰

    另一方面，作为一个类：
        >类内可以定义属性、方法、构造器等
        >可以被final修饰，表示此类不能被继承
        >可以被abstract修饰，表示此类不能被实例化

4. 关注如下的3个问题
    4.1 如何实例化成员内部类的对象
    4.2 如何在成员内部类中区分调用外部类的结构
    4.3 开发中局部内部类的使用

 */

public class InnerClassTest {

    public static void main(String[] args) {

        //创建Brain实例（静态的成员内部类）
        Person.Brain brain = new Person.Brain();
        brain.think();

        //创建Stomach实例（非静态的成员内部类）
        Person p = new Person();
        Person.Stomach stomach = p.new Stomach();
        stomach.digest();
        stomach.display("恰饭");

    }

    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable(){

        //创建一个实现了Comparable接口的类：局部内部类
        //方式一：
//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//
//        return new MyComparable();

        //方式二：
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }

}

class Person{

    String name = "小明";
    int age;

    public void eat(){
        System.out.println("人吃饭");
    }

    //静态成员内部类
    static class Brain{

        String name = "大脑";
        int nerve;

        public void think(){
            System.out.println("思考");
        }

    }

    //非静态成员内部类
    class Stomach{

        String name = "胃";

        public Stomach(){

        }

        public void digest(){
            Person.this.eat();//调用外部类的非静态结构
            System.out.println("消化食物");
        }

        public void display(String name){
            System.out.println(name);//方法的形参
            System.out.println(this.name);//内部类的属性
            System.out.println(Person.this.name);//外部类的属性
        }

    }

    public void method(){

        //在局部内部类的方法中（比如show）如果调用局部内部类所在的方法（比如method）中的局部变量（比如num），
        //要求此变量声明为final
        int num = 10;
        //局部内部类
        class AA{
            public void show(){
//                num = 20;
                System.out.println(num);
            }
        }
    }

    {   //局部内部类
        class BB{}
    }

    public Person(){
        //局部内部类
        class CC{}
    }
}
