package com.th1024.String;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @author TuHong
 * @create 2021-01-27 13:46
 */
public class StringBufferBuilderTest {

    /*
    常用方法：
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int start,intend) ：删除指定位置的内容
    StringBuffer replace(int (int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert (int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse()：把当前字符序列逆转

    public int indexOf (String str)
    public String substring (int start,int end)//返回一个从start开始到end索引结束的左闭右开区间的子字符串
    public int length()
    public char charAt(int n)
    public void setCharAt(int n,char ch)

    总结：
    增：append(xxx)
    删：delete(int start,int start,intend)
    改：setCharAt(int n,char ch) / replace(int (int start, int end, String str)
    查：charAt(int n)
    插：insert (int offset, xxx)
    长度：length()
    *遍历：for() + charAt() / toString()
     */
    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);
//        sb1.delete(2,4);
//        sb1.replace(2,4,"hello");
//        sb1.insert(2,false);
//        sb1.reverse();
        String s1 = sb1.substring(1, 3);
        System.out.println(sb1.length());
        System.out.println(sb1);
        System.out.println(s1);

    }

    /*
     String、StringBuffer、StringBuilder三者的异同？
     相同：
     1. 底层均使用char[]进行存储

     不同：
     String：不可变的字符序列
     StringBuffer：可变的字符序列  线程安全的，效率偏低
     StringBuilder：可变的字符序列  JDK5.0新增，线程不安全，效率高

     效率从高到低排列：StringBuilder -- StringBuffer -- String

     源码分析：
     String str = new String();//char[] value = new char[0];
     String str = new String("abc);//char[] value = new char[]{'a','b','c'};

     StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建长度为16的char[]
     sb1.append('a');//value[0] = 'a';
     sb2.append('b')'//value[1] = 'b';

     StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length + 16]

     问题一：System.out.println(sb2.length())//3
     问题二：扩容--默认扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组
            指导意义：开发中建议大家使用：StringBuffer(int capacity)或StringBuilder(int capacity)

     */
    @Test
    public void test1(){

        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }
}
