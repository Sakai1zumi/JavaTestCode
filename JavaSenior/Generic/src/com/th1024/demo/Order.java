package com.th1024.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 * @author TuHong
 * @create 2021-02-02 15:16
 */
public class Order <T>{

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){};

    public Order(String orderName, int orderId ,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //泛型方法：在方法中出现了泛型的结构，泛型的参数与类的泛型参数没有关系
    //泛型方法可以声明为静态，泛型参数在调用方法时指定，并非在实例化类时指定
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;
    }


    //如下的三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态的方法中，不能使用泛型
//    public static void show(){
//        System.out.println(orderT);
//    }
}
