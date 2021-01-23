package com.oop.demo08;

/*
final关键字

1. final可以用来修饰的结构：类、方法、变量

2. final修饰类：此类不能被其他类所继承
            比如：String类、System类、StringBuffer类

3. final修饰方法：此方法不能被重写
            比如：Object类中getClass()方法

4. final修饰变量：此变量就称为“常量”
    4.1 final修饰属性--可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
    4.2 final修饰局部变量--尤其是使用final修饰形参时，表名此形参是一个常量，赋值后只能使用，不能修改

5. static final用来修饰属性：全局常量

 */

public class FinalTest {

    final int WIDTH = 0;
    final int LEFT;
    final int RIGHT;
//    final int DOWN;

    {
        LEFT = 1;
    }

    public FinalTest(){
        RIGHT = 2;
    }

    public FinalTest(int n){
        RIGHT = n;
    }

//    public void setDOWN(int down){//final修饰属性不能通过方法赋值
//        this.DOWN = down;
//    }


    public static void main(String[] args) {

    }
}

final class FinalA{

}

//class B extends FinalA{
//
//}

class AA{
    final public void show(){

    }
}

//class BB extends AA{
//    public void show(){//不能被重写
//
//    }
//}
