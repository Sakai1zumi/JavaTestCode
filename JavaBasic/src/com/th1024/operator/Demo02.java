package com.th1024.operator;

public class Demo02 {
    public static void main(String[] args) {

        //三元运算符
        //x ? y : z--如果x==true，则结果为y，否则为z
        int score = 50;
        String type = score < 60 ? "不及格" : "及格";//必须掌握
        System.out.println(type);

//        int a = 10;
//        int b = 20;
//        System.out.println(a+=b);
//        System.out.println(a-=b);
//        //字符串连接符  + ，String
//        System.out.println(""+a+b);//把a和b当String连接起来
//        System.out.println(a+b+"");//先运算

        //位运算符
        /*
        A=0011 1100
        B=0000 1101

        A&B = 0000 1100
        A|B = 0011 1101
        A^B = 0011 0001  异或
        ~B = 1111 0010

        计算2*8 = 16
        <<  左移
        >>  右移
        效率极高！
        0000 0000    0
        0000 0001    1
        0000 0010    2
        0000 0011    3
        0000 0100    8
        0000 1000    16

         */
//        System.out.println(2<<3);




//        //与  或  非
//        boolean a = true;
//        boolean b = false;
//
//        System.out.println("a && b:"+(a&&b));//逻辑与运算
//        System.out.println("a || b:"+(a||b));//逻辑或运算
//        System.out.println("!(a && b):"+!(a&&b));//逻辑非运算
//
//        //短路运算
//        int c = 5;
//        boolean d = (c<4)&&(c++<4);
//        System.out.println(d);
//        System.out.println(c);//5,不执行c++

//        //++ -- 一元运算符
//        int a = 3;
//        int b = a++;//执行这行代码后，先给b赋值，再自增
//        //a = a + 1;
//        System.out.println(a);
//        //a = a + 1;
//        int c = ++a;//执行这段代码前，先自增，再给c赋值
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//
//        //幂运算  2^3 很多运算，我们会使用一些工具类来操作
//        double pow = Math.pow(2, 3);
//        System.out.println(pow);
    }
}
