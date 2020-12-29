package com.th1024.array;

public class Demo05 {

    public static void main(String[] args) {

        //多维数组
        int[][] array = {{1,2},{3,4},{5,6}};

        printArray(array[0]);

        System.out.println("===========");

        System.out.println(array[0][0]);
        System.out.println(array[0][1]);
        System.out.println(array[1][0]);
        System.out.println(array[1][1]);
        System.out.println(array[2][0]);
        System.out.println(array[2][1]);

        System.out.println("===========");

        System.out.println(array.length);
        System.out.println(array[0].length);

        System.out.println("===========");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }

        }

    }

    //打印数组元素
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
