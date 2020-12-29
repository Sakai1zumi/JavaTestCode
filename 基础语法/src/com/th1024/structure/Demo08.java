package com.th1024.structure;

public class Demo08 {
    public static void main(String[] args) {
        int i = 0;
        while(i<100){
            i++;
            if(i%10==0){
            System.out.println();
            continue;//终止某次循环，跳过循环中未执行的语句
            }
            System.out.print(i+" ");
        }
    }
}
