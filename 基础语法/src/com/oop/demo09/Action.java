package com.oop.demo09;

//abstract关键字，抽象类
public abstract class Action {

    //抽象方法，约束，只有方法名字，没有方法体
    //有人帮我们实现
    public abstract void doSomething();

    //1.抽象类不能new出来，只能靠子类实现：约束
    //2.抽象类中可以写普通方法，抽象方法必须存在于抽象类中
}
