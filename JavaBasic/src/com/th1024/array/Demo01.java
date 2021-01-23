package com.th1024.array;

public class Demo01 {

    public static void main(String[] args) {
        int[] nums = new int[10];

        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        nums[3]=4;
        nums[4]=5;
        nums[5]=6;
        nums[6]=7;
        nums[7]=8;
        nums[8]=9;
        nums[9]=10;

        //计算所有元素的和
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);

        //ArrayIndexOutOfBoundsException--数组下标越界异常
        //System.out.println(nums[10]);

//        //NullPointerException--空指针异常
//        //情况一
//        int[] arr = {1,2,3,4,5};
//        arr = null;
//        System.out.println(arr[0]);
//        //情况二
//        int[][] arr = new int[4][];
//        System.out.println(arr[0][0]);
//        //情况三
//        String[] arr = new String[]{"aa","bb","cc"};
//        arr[0] = null;
//        System.out.println(arr[0].toString());

    }
}
