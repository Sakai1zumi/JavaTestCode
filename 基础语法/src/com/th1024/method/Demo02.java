package com.th1024.method;

public class Demo02 {

    public static void main(String[] args) {
        double max = MaxOfNumbers(10.0,10.0);
        System.out.println(max);
    }

    //比大小
    public static int MaxOfNumbers (int num1,int num2){

        int result = -1;

        if(num1==num2){
            System.out.println("num1==num2");
            return 0;//终止方法
        }else if(num1<num2){
            result = num2;
        }else{
            result = num1;
        }
        return result;
    }

    //方法重载
    public static double MaxOfNumbers (double num1,double num2){

        double result = -1;

        if(num1==num2){
            System.out.println("num1==num2");
            return 0;//终止方法
        }else if(num1<num2){
            result = num2;
        }else{
            result = num1;
        }
        return result;
    }

}
