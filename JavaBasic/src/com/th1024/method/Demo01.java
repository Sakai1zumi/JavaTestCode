package com.th1024.method;

public class Demo01 {
    //main方法
    public static void main(String[] args) {

        //实际参数，实际传递给方法的参数
        int sum = add(1, 2);
        System.out.println(sum);

        //test();
    }

    //加法方法
    //形式参数，用来定义
    public static int add(int a, int b){
        return a+b;
    }

    //定义方法
    public static void test(){
        for(int i=1;i<=5;i++){
            for(int j=5;j>=i;j--){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
