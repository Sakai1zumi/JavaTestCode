package com.th1024.structure;

public class Demo02 {
    public static void main(String[] args) {
        //case 穿透  switch可以匹配具体的值
        //JDK7的新特性，表达式结果可以是字符串！！！

        //反编译 Java--class（字节码文件）--反编译

        String name = "涂鸿";

        switch(name){
            case "涂鸿":
                System.out.println("涂鸿");
                break;
            case "TuHong":
                System.out.println("TuHong");
                break;
            default:
                System.out.println("---");
                break;
        }

//        char grade = 'A';
//        switch(grade){
//            case 'A':
//                System.out.println("优秀");
//                break;
//            case 'B':
//                System.out.println("良好");
//                break;
//            case 'C':
//                System.out.println("合格");
//            case 'D':
//                System.out.println("不及格");
//                break;
//            default:
//                System.out.println("未知等级");
//        }

    }
}
