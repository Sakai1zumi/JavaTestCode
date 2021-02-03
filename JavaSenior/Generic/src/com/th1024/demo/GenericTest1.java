package com.th1024.demo;

import org.junit.Test;

import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *
 * @author TuHong
 * @create 2021-02-02 15:31
 */
public class GenericTest1 {

    //测试泛型方法
    @Test
    public void test3(){
        Order<String> order = new Order<>();

        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //如果类带泛型，建议实例化时指明类的泛型
        Order<String> order1 = new Order<>("OrderAA",1001,"Order:AA");

        order1.setOrderT("AA:Hello");
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //子类继承带泛型的父类时，如果指明了泛型类型，则实例化时不需要额外指明
        sub1.setOrderT(123);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("123");
    }
}
