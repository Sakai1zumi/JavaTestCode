package com.oop.demo10.newinjdk8;

/*
JDK8中的新特性
 */

public class SubClassTest {

    public static void main(String[] args) {

        SubClass s = new SubClass();

        //知识点1：接口中定义的静态方法，只能通过接口来调用
//        s.method1();

        //知识点2：通过实现类的对象，可以调用接口中的默认方法
        CompareA.method1();
        s.method2();

        //如果实现类重写了接口中的默认方法，调用时调用的是实现类中重写的方法
        s.method3();

        //知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，
        //那么子类在没有重写此方法的情况下，默认调用的是父类中的方法--类优先原则
        //知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
        //那么实现类没有重写此方法的情况下，报错-->接口冲突
        s.method4();
    }

}

class SubClass extends SuperClass implements CompareA,CompareB{

    public void method3(){
        System.out.println("compareA：默认方法2SubClass重写");
    }

    @Override
    public void method4() {
        System.out.println("SubClass：方法");
    }

    public void myMethod(){
        method4();//调用的自定义重写方法
        super.method4();//调用父类中声明的方法
        //调用接口中的默认方法
        CompareA.super.method4();
        CompareB.super.method4();
    }
}

interface CompareA {

    public static void method1(){
        System.out.println("compareA：静态方法");
    }

    public default void method2(){
        System.out.println("compareA：默认方法1");
    }

    default void method3(){
        System.out.println("compareA：默认方法2");
    }

    default void method4(){
        System.out.println("compareA：默认方法3");
    }
}

interface CompareB{

    default void method4(){
        System.out.println("compareB：默认方法3");
    }
}

class SuperClass{

    public void method4(){
        System.out.println("SuperClass：方法");
    }
}
