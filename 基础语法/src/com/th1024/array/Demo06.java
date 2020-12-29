package com.th1024.array;

import java.util.Arrays;

public class Demo06 {

    public static void main(String[] args) {

        int [] a = {2,5,8,9,34,6,8989,32,4,87,33,21,546};

        //System.out.println(a);//[I@1b6d3586

        System.out.println(Arrays.toString(a));

        System.out.println("===============");

        printArray(a);

        Arrays.sort(a);//数组进行排序：升序
        System.out.println(Arrays.toString(a));

        Arrays.fill(a,2,4,0);//指定位置填充，左闭右开区间
        System.out.println(Arrays.toString(a));
    }

    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++) {
            if(i==0){
                System.out.print("["+array[i]+", ");
            }else if(i== array.length-1){
                System.out.print(array[i]+"]"+"\n");
            }else {
                System.out.print(array[i]+", ");
            }
        }
    }
}
