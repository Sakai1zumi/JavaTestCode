package com.th1024.structure;

public class Demo06 {
    public static void main(String[] args) {
        //打印九九乘法表

        int i ;
        int j ;
        for(i=1;i<=9;i++){
            for(j=1;j<=i;j++){
                System.out.print(i+"x"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
