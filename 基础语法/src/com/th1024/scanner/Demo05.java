package com.th1024.scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入多个数字，求其总和和平均数，输入一个数字用回车确认，输入非数字结束输入并输出结果

        Scanner scanner = new Scanner(System.in);

        //和
        double sum =0;
        //计算输入了多少个数字
        int m = 0;

        //通过循环判断是否还有输入，并在里面对每一次进行求和和统计
        while(scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m++;
            sum+=x;
            System.out.println("你当前输入的数据为第"+m+"个数据，当前结果为sum="+sum);
        }

        System.out.println(m+"个数的和为"+sum);
        System.out.println(m+"个数的平均数为"+(sum/m));

        scanner.close();


    }
}
