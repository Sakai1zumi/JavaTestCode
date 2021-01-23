package com.th1024.method;

public class Demo06 {
    public static void main(String[] args) {
        System.out.println(f(5));

        System.out.println("======================");

        System.out.println(new Demo06().f1(10));

        System.out.println("======================");

        Demo06 test = new Demo06();
        for (int n = 1; n <= 10; n++) {
            System.out.print(test.f2(n) + "\t");
        }
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

    //已知有一个数列，f(0) = 1,f(1) = 4,f(n+2) = 2*f(n+1) + f(n)
    //其中n是大于0的整数，求f(10)的值
    public int f1(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 4;
        }else {
            //return f(n+2) - 2*f(n+1)
            return 2*f1(n-1) + f1(n-2);//递归要向着已知方向
        }

    }

    //斐波那契数列--输入一个数据n，计算斐波那契数列的第n个值,并将整个数列打印出来
    public int f2(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else{
            return f2(n-1) + f2(n-2);
        }

    }


}



