package com.th1024.structure;

public class Demo03 {
    public static void main(String[] args) {
        //输出1-100
        //计算1+2+3...+100

        int i = 0;
        int sum=0;

        //先执行后判断
        do {
            sum += ++i;
        }while(i<100);

//        //先判断后执行
//        while(i<100){
//            i++;
//            sum += i;
//        }
        System.out.println("1+2+3...+100="+sum);

//        int i = 0;
//        while(i<100){
//            i++;
//            System.out.println(i);
//        }
    }
}
