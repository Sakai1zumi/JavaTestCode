package com.th1024.structure;

public class PrimeNumbers {

    public static void main(String[] args) {

        //输出100以内所有质数

//        boolean flag = false;//利用标识位判断i是否被j除尽
//            for(int i = 2; i <= 100 ; i++){
//
//                for(int j = 2; j < i ; j++){//j被i去除
//                    if(i % j == 0){//i被j除尽
//                        flag = true;//一旦除尽，修改其值
//                    }
//                }
//                if(!flag){
//                    System.out.print(i+" ");
//                }
//                flag = false;//对下一个i重置flag
//        }

        //优化
        //获取当前时间距离1970-01-01 00:00:00 的毫秒数
//        long start  = System.currentTimeMillis();
//        int cnt = 0;//计算质数的个数
//        boolean flag = false;//利用标识位判断i是否被j除尽
//        for (int i = 2; i <= 100000; i++) {
//
//            for (int j = 2; j <= Math.sqrt(i); j++) {//j被i去除
//                //优化2，j只需要循环到根号i：对本身是指数的数值有效
//                if (i % j == 0) {//i被j除尽
//                    flag = true;//一旦除尽，修改其值、
//                    break;//优化1：只对本身非质数的数值有效
//                }
//            }
//            if (!flag) {
//                //System.out.print(i + " ");
//                cnt++;
//            }
//            flag = false;//对下一个i重置flag
//        }
//
//        long end  = System.currentTimeMillis();
//        System.out.println("质数的个数为："+ cnt);
//        System.out.println("所花费的时间为："+(end - start));
        //未优化    优化1    优化2
        //13.764s--1.241s--0.01s

        //方法二
        long start  = System.currentTimeMillis();
        int cnt = 0;

        label:for (int i = 2; i <= 100000; i++) {

            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {
                    continue label;//带标签的continue和break；
                }
            }
            //能执行到此步的都是质数
            cnt++;
        }

        long end  = System.currentTimeMillis();
        System.out.println("质数的个数为："+ cnt);
        System.out.println("所花费的时间为："+(end - start));
    }
}