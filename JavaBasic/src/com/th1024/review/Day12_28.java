package com.th1024.review;

import java.util.Scanner;

public class Day12_28 {
    public static void main(String[] args) {
        System.out.println("请输入数字，按回车输入下一个，输入非数字结束：");

        Scanner scanner = new Scanner(System.in);

        double x ;
        double sum = 0;
        int cnt = 0;

        while(scanner.hasNextDouble()){
            x = scanner.nextDouble();
            cnt++;
            sum+=x;
            System.out.println("你输入了第"+cnt+"个数字，现在总和为sum="+sum);
        }
        System.out.println("总共输入了"+cnt+"个数字，它们的平均数为"+(sum/cnt));

        scanner.close();
    }
}
