package com.th1024.base;

public class demo03 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出问题
        //JDK7新特性，数字之间可以用下划线分割
        int money = 10_0000_0000;
        int years = 20;
        int total = money*years;
        long total1 = money*years;
        long total2 = ((long)money)*years;//类型转换
        System.out.println(total);//-1474836480
        System.out.println(total1);//默认为int，转换之前已经存在问题
        System.out.println(total2);//正常输出




        int i =128;
        byte b = (byte)i;//内存溢出
        double c = i;
        System.out.println(i);
        System.out.println(b);
        System.out.println(c);
        //强制转换 （类型）变量名  高--低
        //自动转换  低--高

        /*
        * 注意点：
        * 1.不能对布尔值进行转换
        * 2.不能把对象类型转换为不相干的类型
        * 3.在把高容量转换到低容量的时候，强制转换
        * 4.转换的时候可能存在内存溢出，或者精度问题
        * */

        System.out.println("===================");
        char a ='a';
        int d= a+1;
        System.out.println(d);
        System.out.println((char)d);


    }
}
