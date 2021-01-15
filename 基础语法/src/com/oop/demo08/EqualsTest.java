package com.oop.demo08;

/*
面试题：==和equals()的区别

一、回顾 == 的使用：
    ==：运算符
    1. 可以使用在基本数据类型变量和引用数据类型变量中
    2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
       如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即是否指向同一个对象实体。

二、equals()方法的使用：
    1. 是一个方法，而非运算符
    2. 只适用于引用数据类型
    3. Objetc类中equals()的定义：
        public boolean equals(Object obj) {
        return (this == obj);
    }
    说明：Object类中定义的equals()和==作用相同
    4. String、Date、File、包装类等都重写了Object类中的equals()方法。
       重写之后比较的是两个对象的实体内容。
    5. 通常情况下，自定义类中如需使用equals()方法比较两个对象试题内容，需重写equals()方法。
       原则：比较两个对象的实体内容
补充：使用 == 符号时，两边对象类型应保持一致
 */


import java.util.Date;

public class EqualsTest {

    public static void main(String[] args) {

        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);//true
        System.out.println(i == d);//true

        boolean b = true;
//        System.out.println(i == b);

        char c = 10;
        System.out.println(i == c);//true

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);//true

        Customer cust1 = new Customer("Tom",21);
        Customer cust2 = new Customer("Tom",21);
        System.out.println(cust1 == cust2);//false

        String st1 = new String("tuhong");
        String st2 = new String("tuhong");
        System.out.println(st1 == st2);//false

        System.out.println("=============================");

        System.out.println(cust1.equals(cust2));//false--重写equals()之后为true
        System.out.println(st1.equals(st2));//true


        Date date1 = new Date(56565778888L);
        Date date2 = new Date(56565778888L);
        System.out.println(date1.equals(date2));//true

    }
}
