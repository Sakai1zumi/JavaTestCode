package com.oop.demo06;

//多态性的使用举例1

public class AnimalTest {

    public static void main(String[] args) {

        AnimalTest test = new AnimalTest();

        test.func(new Dog());//Animal animal = new Dog();
        System.out.println("****************************");
        test.func(new Cat());//Animal animal = new Cat();

    }

    public void func(Animal animal){
        animal.eat();
        animal.shout();
    }

//    public void func(Dog dog){
//        dog.eat();
//        dog.shout();
//    }
//
//    public void func(Cat cat){
//        cat.eat();
//        cat.shout();
//    }

}

class Animal{

    public void eat(){
        System.out.println("动物进食");
    }

    public void shout(){
        System.out.println("动物喊叫");
    }

}

class Dog extends Animal{

    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void shout(){
        System.out.println("汪汪汪");
    }

}

class Cat extends Animal{

    public void eat(){
        System.out.println("猫吃鱼");
    }

    public void shout(){
        System.out.println("喵喵喵");
    }

}
