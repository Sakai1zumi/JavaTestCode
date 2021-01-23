package com.oop.demo06;

/*
多态性
1.一个事物的多种形态
2.父类的引用指向子类的对象
3.多态的使用：虚拟方法调用
    有了对象的多态性之后，编译期只能调用父类中声明的方法，但在运行期，实际执行的是子类重写的方法
    编译看左边，运行看右边
4.多态性使用前提
    ① 类的继承关系
    ② 方法的重写
5.对象的多态性，只适用于方法，不适用于属性
面试题：多态性是编译时行为还是运行时行为
    答案：运行时行为，方法调用是在运行时确定的，在编译期无法确定
 */

public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person();
        p1.eat();

        Man m = new Man();
        m.eat();
        m.age = 25;
        m.makeMoney();

        System.out.println("*******************************");

        //对象的多态性：父类的引用指向子类的对象
        Person p2 = new Man();
//        Person p3 = new Woman();

        //多态的使用，当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法
        p2.eat();
        p2.walk();

        //p2.makeMoney();--不能调用子类独有的方法
        //有了对象的多态性以后，内存中实际加载了子类特有的属性和方法，
        //但是由于变量声明为父类类型，导致编译时只能调用父类中声明的属性和方法。

        //如何调用子类特有的属性和方法
        //使用强制类型转换符---向下转型
        Man m1 = (Man)p2;
        m1.makeMoney();

        //使用强制转换时，可能出现异常--ClassCastException
//        Woman w1 = (Woman) p2;
//        w1.goShopping();

        /*
        instanceof关键字的使用

        a instanceof A：判断对象a是否是类A的实例。如果是，返回true，反之返回false

        如果a instanceof A返回true，a instanceof B也返回true，
        则B为A的父类
         */
        //使用情景,为了避免向下转型时出现异常，在转型之前先进行instanceof判断
        if(p2 instanceof Woman){
            Woman w1 = (Woman) p2;
            w1.goShopping();
            System.out.println("*****woman******");
        }

        if(p2 instanceof Man){
            Man m2 = (Man) p2;
            m2.makeMoney();
            System.out.println("*****man******");
        }

        //问题一：编译时通过，运行时不通过
//        Woman w1 = (Woman) p2;
//        w1.goShopping();

//        Person p3 = new Person();
//        Man m3 = (Man)p3;

        //问题二：编译时通过，运行时也通过
        Object obj = new Woman();
        Person p = (Person)obj;
        p.walk();

        //问题三：编译时不通过
//        Man m4 = new Woman();









//        //一个对象的实际类型是确定的
//        //Student s1;
//        //Person s2;
//
//        //可以指向的类型就不确定了：父类的引用指向了子类
//
//        //Student能调用的方法都是自己的或者继承父类的方法
//        Student s1 = new Student();
//        //Person 父类型，可以指向子类，但不能调用子类独有的方法
//        Person s2 = new Student();
//        Object s3 = new Student();
//
//        s1.run();//子类重写了父类的方法，执行子类的方法
//        s2.run();
//
//        //对象能执行哪些方法，主要看对象左边的类型
//        s1.eat();
//        //s2.eat();//不能调用子类独有的方法


    }

}
