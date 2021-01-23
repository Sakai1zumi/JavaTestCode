package com.th1024.structure;

public class TestDemo02 {

    public static void main(String[] args) {
        //打印菱形  5行
        int line = 5;

        for(int i=1;i<=line;i++){
            if(i<=3) {
                for (int j = line/2; j >= i; j--) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                for (int j = 1; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }else{
                for(int j=line/2+1;j<i;j++){
                    System.out.print(" ");
                }
                for(int j=line;j>=i;j--){
                    System.out.print("*");
                }
                for(int j=line;j>i;j--){
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }
}
