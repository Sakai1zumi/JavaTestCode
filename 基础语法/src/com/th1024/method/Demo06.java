package com.th1024.method;

public class Demo06 {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    //递归思想求阶乘
    public static int f(int n){
        int result;
        if(n==1){
            result = 1;
        }else{
            result = n * f(n - 1);
        }
        return result;
    }
}
