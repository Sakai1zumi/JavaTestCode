package com.th1024.array;

import java.util.*;// .* --导入util工具包下的所有结构
import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};

        //排序
        int[] result = testSort(arr);
        System.out.println(Arrays.toString(result));

        //查找
        testSearch(arr,22);
        testSearch(arr,3);

        //反转
        int[] result1 = testReverse(arr);
        System.out.println(Arrays.toString(result1));

        //复制
        int[] result2 = testCopy(arr);
        System.out.println(Arrays.toString(result2));

    }

    public static int[] testSort(int[] arr){

        int temp;
        boolean isFlag;

        for (int i = 0; i < arr.length - 1; i++) {
            isFlag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isFlag = true;
                }
            }
            if(!isFlag){
                break;
            }
        }
        return arr;
    }

    public static int[] testReverse(int[] arr){

        int temp;

        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-1 - i];
            arr[arr.length-1 - i] = temp;
        }

        return arr;
    }

    public static int[] testCopy(int[] arr){

        int[] CopyOfArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            CopyOfArr[i] = arr[i];
        }

        return CopyOfArr;
    }

    public static void testSearch(int[] arr,int dest){

        int index = -1;

        int head = 0;
        int end = arr.length-1;
        int middle;

        while(head <= end){

            middle = (head + end)/2;

            if(dest == arr[middle]){
                index = middle;
                System.out.println("指定元素位置为："+ index);
                break;
            }else if(dest < arr[middle]){
                end = middle - 1;
            }else{
                head = middle + 1;
            }
        }
        if(index < 0){
            System.out.println("未找到指定元素");
        }

    }

}


