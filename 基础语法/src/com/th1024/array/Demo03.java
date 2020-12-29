package com.th1024.array;

public class Demo03 {

    public static void main(String[] args) {
        int[] arrays = {5,7,3,6,8};

        //打印数组元素
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
        System.out.println("===================");
        //计算所有元素的和
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i];
        }
        System.out.println(sum);

        //查找最大元素
        int max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if(arrays[i]>max){
                max = arrays[i];
            }
        }
        System.out.println("max="+max);
    }
}
