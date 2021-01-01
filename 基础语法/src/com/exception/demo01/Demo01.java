package com.exception.demo01;

public class Demo01 {

    public static void main(String[] args) {

//        int a = 1;
//        int b = 0;
//
//        try{ //try 监控区域
//            System.out.println(a/b);
//        }catch (ArithmeticException e){ //catch(想要捕获的异常类型) 捕获异常
//            System.out.println("程序异常");
//        }finally { //处理善后工作，可以不存在
//            System.out.println("finally");
//        }


        //假设要捕获多个异常，按照异常的范围从小到大
        try {
            new Demo01().a();
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Error e){
            System.out.println("Error");
        }catch (Throwable t){
            System.out.println("Throwable");
        }
        finally {
            System.out.println("finally");
        }
    }

    public void a(){b();}
    public void b(){a();}


}
