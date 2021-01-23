package com.th1024.base;

public class demo02 {
    public static void main(String[] args) {
        //八大基本数据类型

        //整数
        int num1 = 10; //最常用
        byte num2 = 100;
        short num3 = 30;
        long num4 = 30L;//long类型要在数字后面加个L

        //小数--浮点数
        float num5 = 50.1F;//float类型要在数字后面加个F
        double num6 = 3.14159265359;

        //字符
        char name = 'A';
        //字符串，String不是关键字，是类
        String name1 = "tuhong";

        //布尔值
        boolean flag = true;
        //boolean flag = false;

        //整数拓展：进制  二进制0b  十进制  八进制0  十六进制0x
        int i = 10;
        int i2 = 010;
        int i3 = 0x10;

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("==================================");

        //浮点数拓展  银行业务怎么表示
        // float  有限  离散  舍入误差  大约  接近但不等于
        // double
        //最好完全避免使用浮点数进行比较
        //最好完全避免使用浮点数进行比较
        //最好完全避免使用浮点数进行比较
        float f = 0.1f;
        double d = 1.0 / 10;

        System.out.println(f == d);
        System.out.println(f);
        System.out.println(d);

        float d1 = 23232323232323232323f;
        float d2 = d1 + 1;
        System.out.println(d1 == d2);
        System.out.println("==================================");

        char c1 = 'a';
        char c2 = '中';
        System.out.println(c1);
        System.out.println((int) c1);//强制转换
        System.out.println(c2);
        System.out.println((int) c2);
        //所有的字符本质还是数字
        //编码 Unicode表

        char c3 = '\u0061';
        System.out.println(c3);//a

        //转义字符  \t:制表符  \n:换行  ...
        System.out.println("BaseVariable.Hello\tWorld");

        //布尔值拓展
        boolean falg1 = true;
        if (flag == true) {
        }
        if (flag) {
        }//完全等价

    }
}