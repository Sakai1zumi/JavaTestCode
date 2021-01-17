package com.th1024.java1;

import org.junit.Test;

public class WrapperTest {

    /*
    关于包装类使用面试题
     */
    @Test
    public void test6(){
        Object o1 = true ? new Integer(1) : new Double(2.0);//冒号两边类型自动提升至统一
        System.out.println(o1);//1.0
    }
    @Test
    public void test7(){
        Object o2;
        if(true) o2 = new Integer(1);
        else o2 = new Double(2.0);
        System.out.println(o2);
    }
    @Test
    public void test8(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        //Integer内部定义了Integer cache[] -- 范围：-128-127
        //如果使用自动装箱的方式给Integer赋值时，值在范围内，直接使用数组中的元素
        //目的：提高效率
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
    }

    //String类型--->基本数据类型，包装类：调用包装类的parseXxx()
    @Test
    public void test5(){
        String str1 = "123";
        //错误情况
//        int num1 = (int) str1;
//        Integer in1 = (Integer) str1;

        int num2 = Integer.parseInt(str1);
        System.out.println(num2);

        String str2 = "true";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }

    //基本数据类型，包装类--->String类型：调用String重载的valueOf(Xxx xxx)
    @Test
    public void test4(){

        int num1 = 10;
        //方式1：连接运算
        String str1 = num1 + "";
        //方式2：调用String重载的valueOf(Xxx xxx)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);

        Double d1 = 12.3;
        String str3 = String.valueOf(d1);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }


    /*
    JDK5.0新特性：自动装箱与自动拆箱
     */
    @Test
    public void test3(){

        //自动装箱：基本数据类型--->包装类
        int num1 = 10;
        method(num1);
        Integer in1 = num1;

        boolean b1 = true;
        Boolean b2 = b1;

        //自动拆箱：包装类-->基本数据类型
        int num3 = in1;
        System.out.println(num3 + 1);
    }

    public void method(Object obj){
        System.out.println(obj);
    }


    //包装类-->基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2(){

        Integer in1 = new Integer(12);
        int i1 =in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3f);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }

    //基本数据类型--->包装类：调用包装类的构造器
    @Test
    public void test1(){

        int num1 = 10;
        Integer in1 = new Integer(num1);
        System.out.println(in1.toString());

        Integer in2 = new Integer("123");
        System.out.println(in2.toString());

        //报异常
//        Integer in3 = new Integer("123abc");

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3f");
        System.out.println(f1);
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("true123");//false
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Order order = new Order();
        System.out.println(order.isMale);//false
        System.out.println(order.isFemale);//null

    }
}

class Order{
    boolean isMale;
    Boolean isFemale;
}
