package com.oop.demo08;

/*
Object类中，toString()的使用
1. 我们输出一个对象时，实际上是在调用对象的toString()方法

2. Object类中，toString()的定义
    public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }

3. String、Date、File、包装类等都重写了Object类中的toString()方法，
   在调用toString()方法时，返回实体内容。

4. 自定义类可重写toString()方法，输出对象实体内容。
 */

import java.util.Date;

public class ToStringTest {

    public static void main(String[] args) {

        Customer cust = new Customer("Tom",21);
        System.out.println(cust.toString());//com.oop.demo08.Customer@1b6d3586-->Customer{name='Tom', age=21}
        System.out.println(cust);//com.oop.demo08.Customer@1b6d3586

        String str = new String("AA");
        System.out.println(str);//AA

        Date date = new Date(438458559606L);
        System.out.println(date);//Thu Nov 24 02:02:39 CST 1983

    }
}
