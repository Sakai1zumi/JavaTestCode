package com.th1024.scanner;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入数据：");

        String str = scanner.nextLine();
        System.out.println("输出的结果为：" +str);

        scanner.close();
    }
}
