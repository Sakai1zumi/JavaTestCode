package com.th1024.structure;

//一个属如果恰好等于它的因子之和，这个数就成为完数。例如6=1+2+3.
//找出1000以内的所有完数（因子：除去这个数本身的其它约数）

public class TestDemo03 {

    public static void main(String[] args){

        int sum = 0;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j < i/2; j++) {
                if(i % j == 0){//找出i的因子
                    sum += j;//将i的因子累加
                }
            }
            if(i == sum){//判断是否相等
                System.out.println(i);
            }
            sum = 0;//重置sum（不能忘记！）
        }

    }
}
