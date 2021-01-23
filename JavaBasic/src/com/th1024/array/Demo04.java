package com.th1024.array;

public class Demo04 {

    public static void main(String[] args) {
        int[] arrays = {34,7,43,6,37,89,2};

        //JDK1.5新特性，没有下标
        for (int array : arrays) {
            System.out.print(array+" ");
        }
        System.out.println();
        System.out.println("===================");

        printArray(arrays);

        System.out.println("===================");

        int[] reverse = reverse(arrays);
        printArray(reverse);
    }

    //打印数组元素
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //反转数组
    public static int[] reverse(int[] arrays){

        for (int i = 0, j = arrays.length-1;i < j ; i++,j--) {
            int temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }
        return arrays;
    }
}
