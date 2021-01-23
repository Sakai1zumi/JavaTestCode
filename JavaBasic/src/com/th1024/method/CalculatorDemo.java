package com.th1024.method;

import java.util.Scanner;

public class CalculatorDemo {

    public static void main(String[] args) {


            System.out.println("请选择计算方式" +
                    "（1代表+，2代表-，3代表*，4代表/)：");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            switch (i){
                case 1: {
                    System.out.println("请输入两个数，按回车输入下一个");
                    Scanner scanner1 = new Scanner(System.in);
                    double x = scanner1.nextDouble();
                    double y = scanner1.nextDouble();
                    scanner1.close();
                    add(x,y);
                    break;
                }
                case 2:{
                    System.out.println("请输入两个数，按回车输入下一个");
                    Scanner scanner2 = new Scanner(System.in);
                    double x = scanner2.nextDouble();
                    double y = scanner2.nextDouble();
                    scanner2.close();
                    minus(x,y);
                    break;
                }
                case 3:{
                    System.out.println("请输入两个数，按回车输入下一个");
                    Scanner scanner3 = new Scanner(System.in);
                    double x = scanner3.nextDouble();
                    double y = scanner3.nextDouble();
                    scanner3.close();
                    multiply(x,y);
                    break;
                }
                case 4:{
                    System.out.println("请输入两个数，按回车输入下一个");
                    Scanner scanner4 = new Scanner(System.in);
                    double x = scanner4.nextDouble();
                    double y = scanner4.nextDouble();
                    scanner4.close();
                    divide(x,y);
                    break;
                }
                default:
                    System.out.println("非法输入");
                    break;

            }
            scanner.close();


    }

    public static void add(double a,double b){
        System.out.println(a+"+"+b+"="+(a+b));
    }

    public static void minus(double a,double b){
        System.out.println(a+"-"+b+"="+(a-b));
    }

    public static void multiply(double a,double b){
        System.out.println(a+"*"+b+"="+(a*b));
    }

    public static void divide(double a,double b){
        if (b==0){
            System.out.println("除数不能为0");
            return;
        }
        System.out.println(a+"/"+b+"="+(a/b));
    }

}
