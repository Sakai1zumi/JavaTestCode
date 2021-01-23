package com.th1024.array;

import java.util.Arrays;

public class Demo06 {

    public static void main(String[] args) {

        int[] a = {2,5,8,9,34,6,8989,32,4,87,33,21,546};
        int[] b = {1,5,8,9,34,6,8989,32,4,87,33,21,546};

        boolean isEquals = Arrays.equals(a,b);//判断两个数组是否相等
        System.out.println(isEquals);

        //System.out.println(a);//[I@1b6d3586

        System.out.println(Arrays.toString(a));

        System.out.println("===============");

        printArray(a);

        Arrays.sort(a);//数组进行排序：升序
        System.out.println(Arrays.toString(a));

        Arrays.fill(a,2,4,0);//指定位置填充，左闭右开区间
        System.out.println(Arrays.toString(a));

        int index = Arrays.binarySearch(a,3);//查找数组元素
        if(index >= 0){
            System.out.println("元素所在位置为："+index);
        }else{
            System.out.println("未找到指定元素");
        }


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
