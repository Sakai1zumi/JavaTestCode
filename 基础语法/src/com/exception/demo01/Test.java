package com.exception.demo01;

public class Test {

    public static void main(String[] args) {

        try {
            new Test().test(1,0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }


        //        int a = 1;
//        int b = 0;
//
//        //快捷键 Ctrl+Alt+t
//        try {
//            System.out.println(a/b);
//        } catch (Exception e) {
//            e.printStackTrace();//打印错误的栈信息
//        } finally {
//        }
    }

    //假设这个方法处理不了异常，即主动抛出异常
    public void test(int a,int b) throws ArithmeticException {
        if(b==0){
            throw new ArithmeticException();//主动抛出异常,一般在方法中使用
        }
        System.out.println(a/b);
    }
}
