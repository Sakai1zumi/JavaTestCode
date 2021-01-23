package com.th1024.method;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //调用可变参数的方法
       printMax(1,45,67.5,9);
       printMax(new double[]{1,2,3});
    }

    public static void printMax(double...numbers){
        if (numbers.length==0){
            System.out.println("No arguments passed");
            return;
        }

        double result = numbers[0];
        //排序
        for(int i=1;i< numbers.length;i++){
            if (numbers[i]>result){
                result = numbers[i];
            }
        }
        System.out.println("The max value is "+result);
    }
}
