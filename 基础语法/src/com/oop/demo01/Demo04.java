package com.oop.demo01;

public class Demo04 {
    //值传递
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        Demo04.change(a);
        System.out.println(a);
    }

    public static void change(int a){
        a = 10;
    }
}
