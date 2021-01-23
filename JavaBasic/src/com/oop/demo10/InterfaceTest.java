package com.oop.demo10;

/*
接口的使用

1. 接口使用interface定义

2. Java中，接口和类是并列的两个结构

3. 如何定义接口：定义接口中的成员

    3.1 JDK7及以前：只能定义全局常量和抽象方法
        >全局常量：public static final，书写时可以省略接口
        >抽象方法：public abstract

    3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

4. 接口中不能定义构造器，意味着接口不可以实例化

5. Java开发中，接口通过让类去实现的方式来使用（implements）
   如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
   如果实现类没有覆盖接口中所有的抽象方法，则此实现类必须声明为abstract

6. Java类可以实现多个接口--->弥补了Java单继承性的局限性
    格式：class AA extends BB implements CC,DD,EE

7. 接口与接口之间可以继承，而且可以多继承

8. 接口的使用体现了多态性

9. 接口实际上可以看作是一种规范

面试题：抽象类与接口有哪些异同？
    >相同点：不能实例化；都可以包含抽象方法
    >不同点：
        1）把抽象类和接口（java7，java8，java9）的定义、内部结构解释说明
        2）类：单继承性    接口：多继承
           类与接口：多实现
 */

import javax.net.ssl.SSLProtocolException;

public class InterfaceTest {

    public static void main(String[] args) {

        System.out.println(Flyable.MAX_SPEED);

//        Flyable.MIN_SPEED = 2;

        Plane plane = new Plane();
        plane.fly();

    }
}

interface Flyable{

    //全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;//省略 public static final

    //抽象方法
    public abstract void fly();

    void stop();//省略 public abstract

}

interface Attackable{

    void attack();

}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("芜湖起飞");
    }

    @Override
    public void stop() {
        System.out.println("肉蛋葱鸡");
    }
}

abstract class Kite implements Flyable{

    @Override
    public void fly() {

    }
}

class Bullet extends Object implements Flyable,Attackable,CC{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }
}

//**************************************************************

interface AA{
    void methodA();
}

interface BB{
    void methodB();
}

interface CC extends AA,BB{

}
