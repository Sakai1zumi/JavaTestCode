package com.th1024.array;

//二分法查找
//只适用于有序数组

public class Demo09 {

    public static void main(String[] args) {
        int [] arr = {-9,-7,-5,-3,1,2,5,8,9};
        int dest1 = -3;
        int dest2 = 0;

        dichotomySearch(arr,-3);
        System.out.println("===============");
        dichotomySearch(arr,0);


    }

    //二分法查找dichotomySearch
    public static void dichotomySearch (int[] array,int dest){
        int head = 0;//初始的首索引
        int end = array.length-1;//初始的末索引
        boolean isFlag = true;

        while(head <= end){
            int middle = (head + end) / 2;

            if(dest == array[middle]){
                System.out.println("已找到指定元素，位置为："+middle);
                isFlag = false;
                break;
            }else if(dest < array[middle]){
                end = middle - 1;
            }else{
                head = middle + 1;
            }

            }
            if(isFlag == true){
                System.out.println("未找到指定元素");

        }
    }
}
