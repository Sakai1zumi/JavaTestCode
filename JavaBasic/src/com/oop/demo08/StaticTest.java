package com.oop.demo08;

/*
static关键字的使用

1. static：静态的
2. 可以修饰：属性、方法、代码块、内部类

3. 使用static修饰属性：静态变量/类变量
    3.1 属性，按是否使用static修饰，分为：静态变量 vs 非静态变量（实例变量）
        实例变量：创建了多个对象，每个对象都独立地拥有一套类中的非静态变量
        静态变量：创建了多个对象，每个对象都共享同一个静态变量
    3.2 static修饰属性的其他说明：
        ① 静态变量随着类的加载而加载，可通过"类.静态变量”的方式进行调用
        ② 静态变量加载早于对象的创建
        ③ 由于类只会加载一次，静态变量在内存中只有一份，存放于方法区的静态域中
        ④       类变量     实例变量
            类    yes         no（编译不通过）
            对象  yes         yes
    3.3 静态属性举例：System.out、Math.PI

4. 使用static修饰方法：静态方法
    ① 随着类的加载而加载，可通过“类.静态方法”的方式进行调用
    ②       静态方法     非静态方法
       类    yes         no（编译不通过）
      对象  yes         yes
    ③ 静态方法中，只能调用静态方法或属性
       非静态方法中，既可以调用静态方法或属性，也可以调用非静态方法或属性

5. static注意点
    5.1 在静态方法中，不能使用this和super关键字
    5.2 关于静态属性和静态方法，从生命周期的角度去理解

6. 开发中如何确定一个属性是否要声明为static？
     >属性可以被多个对象共享，不会随着对象的不同而不同
     >类中的常量也常声明为static

   开发中如何确定一个方法是否要声明为static？
     >操作静态属性的方法，通常声明为static
     >工具类中的方法，习惯上声明为static，比如：Math、Arrays、Collections
 */

public class StaticTest {

    public static void main(String[] args) {

        Chinese.nation = "中国";

        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 40;

        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 30;

        c1.nation = "CHN";
        System.out.println(c2.nation);

        c1.eat();
        Chinese.show();

    }



}

class Chinese{

    String name;
    int age;

    static String nation;

    public void eat(){
        System.out.println("吃饭");
    }

    public static void show(){
        System.out.println("我是一个中国人");
    }

}
