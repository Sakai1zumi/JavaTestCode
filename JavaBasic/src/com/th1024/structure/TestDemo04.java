package com.th1024.structure;

/*
输出
******
*****
****
***
**
*
 */
public class TestDemo04 {

    public static void main(String[] args){

        int line = 6;
        for (int i = 1; i <= line; i++) {
            for (int j = line+1-i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
