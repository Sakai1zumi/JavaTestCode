package com.th1024.structure;

public class Demo05 {
    public static void main(String[] args) {
        //用while或for循环输出1-1000之间能被5整除的数，每行输出3个

        for (int i = 1; i <= 1000; i++) {
            if(i%5==0){
                System.out.print(i+" ");
            }
            if(i%(5*3)==0){
                System.out.println();
                //System.out.println("\n");
            }
        }
    }
}
