package com.th1024.String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类与其他结构之间的转换
 *
 * @author TuHong
 * @create 2021-01-27 11:42
 */
public class StringTest1 {

    /*
     String 与 byte[]之间的转换
     
     编码：String --> byte[]:调用String的getBytes()
     解码：byte[] --> String:调用String的构造器

     编码：字符串 --> 字节
     解码：字节 --> 字符串

     说明：解码时，要求解码时使用的字符集必须与编码时使用的字符集一致，不一致则会出现乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";

        byte[] bytes = s1.getBytes();//使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("***************");

        String s2 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(s2);

        String s3 = new String(gbks);
        System.out.println(s3);//出现乱码，编码集和解码集不一致

        String s4 = new String(gbks, "gbk");//使用gbk字符集进行解码
        System.out.println(s4);
    }

    /*
    String与char[]之间的转换

    String --> char[]:调用String的toCharArray()
    char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String s1 = "abc123";

        char[] charArray = s1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String s2 = new String(arr);
        System.out.println(s2);

    }

    /*
    复习
    String与基本数据类型、包装类之间的转换

    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String s1 = "123";
        int num = Integer.parseInt(s1);

        String s2 = String.valueOf(num);
        String s3 = num + "";

        System.out.println(s2 == s3);
    }
}