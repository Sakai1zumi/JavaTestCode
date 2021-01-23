package com.th1024.array;

public class Demo02 {

    public static void main(String[] args) {
        //静态初始化：创建+赋值
        int[] a = {1,2,3,4,5,6};
        System.out.println(a[0]);

        //动态初始化：包含默认初始化
        int[] b = new int[10];
        b[0] = 10;
        b[1] = 20;
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);
    }
}
