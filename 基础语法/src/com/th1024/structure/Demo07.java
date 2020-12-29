package com.th1024.structure;

public class Demo07 {
    public static void main(String[] args) {
        //增强for循环
        int [] numbers = {10,20,30,40,50};

        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("===============");

        for(int x:numbers){
            System.out.println(x);
        }
    }
}
