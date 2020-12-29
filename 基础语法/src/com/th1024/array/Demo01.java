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

        //数组下标越界
        //System.out.println(nums[10]);
    }
}
