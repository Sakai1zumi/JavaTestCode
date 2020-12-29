package com.th1024.array;

import java.util.Arrays;

public class Demo07 {
    
    /*
    冒泡排序
    1.比较数组中两个相邻的元素，如果第一个数比第二个数大，则交换它们的位置
    2.每一次比较，都会产生一个最大，或者最小的数字
    3.下一轮可以减少一次排序
    4.依次循环
     */
    public static void main(String[] args) {
        int[] a = {11,6,4,8,9,5,232,43,7,3,8,9};

        int[] mysort = mysort(a);

        System.out.println(Arrays.toString(mysort));
        
    }
    
    public static int[] mysort (int[] array){
        int temp = 0;
        //外层循环，判断要走多少次
        for (int i = 0; i < array.length; i++) {
            //boolean flag = false;//通过flag标识位减少没有意义的比较--？？？
            //内层循环
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j+1]<array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //flag = true;
                }
//                if(flag == false){
//                    break;
//                }
            }
        }
        return array;
    }
}
