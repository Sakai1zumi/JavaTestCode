package com.th1024.exception;

/*
一、异常的处理：抓抛模型

过程一：“抛”：程序在执行过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出。
           一旦抛出对象以后，其后的代码就不再执行

           关于异常对象的产生：① 系统自动生成的异常对象
                           ② 手动生成一个异常对象，并抛出（throw）

过程二：“抓”：可以理解为异常的处理方式：① try-catch-finally  ② throws

二、try-catch-finally的使用

try{
    //可能出现异常的代码
}catch(异常类型1 变量名1){
    //处理异常的方式1
}catch(异常类型2 变量名2){
    //处理异常的方式2
}catch(异常类型3 变量名3){
    //处理异常的方式3
}
...
finally{
    //一定会执行的代码
}

说明：
1. finally是可选的
2. 使用try将可能出现异常代码包装起来，根据异常对象类型，在catch中进行匹配
3. catch匹配成功，进行异常处理。处理完成，跳出当前try-catch结构（在没有finally的情况下），继续执行后续代码
4. catch中的异常类型如果没有子父类关系，没有声明顺序规定
   如果满足子父类关系，则子类必须声明在父类之上
5. 常用的异常处理方式：① String getMessage()  ② printStackTrace（常用）
6. 在try结构中声明的变量，在try结构外不能调用
7. try-catch-finally结构可以嵌套使用

体会1：try-catch-finally处理编译时异常，运行时仍可能出现异常
体会2：开发中由于运行时异常比较常见，所以我们通常不针对运行时异常编写try-catch-finally结构
      针对编译时异常，一定要考虑异常处理

finally的使用

1. finally是可选的
2. finally中声明的是一定会被执行的代码，无论在之前是否产生异常
3. 数据库连接、输入输出流、网络编程Socket等资源，需要进行手动资源释放
   此时资源释放操作应该声明在finally当中

三、throws + 异常类型

1. ”throws + 异常类型“写在方法的声明处，指明此方法执行时，可能会抛出的异常
   一旦方法体执行时出现异常，仍会在异常代码处生成一个异常类的对象，匹配抛出的异常类型时就会被抛出
   异常代码后续的代码不会执行
2. 体会：try-catch-finally结构真正将异常处理了
        throws方式只是将异常抛给了方法的调用者，并没有将异常处理掉

四、开发中的异常处理
1. 如果父类中被重写的方法没有使用throws方式处理异常，则子类重写的方法也不能使用throws处理异常
   子类中重写的方法如果存在异常，则必须使用try-catch-finally处理
2. 执行的方法a中，先后又调用了另外几个方法，这几个方法是递进关系执行的，
   则这几个方法建议使用throws，而执行方法a使用try-catch-finally处理

 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {

    public static void main(String[] args) {

        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }

        method3();

    }

    public static void method3(){
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws IOException{
        method1();
    }

    public static void method1() throws FileNotFoundException,IOException{

        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.print((char) data);
            data = fis.read();
        }

        fis.close();

    }

    @Test
    public void test4(){

        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1){
                System.out.print((char) data);
                data = fis.read();
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis != null)//防止空指针异常
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testMethod(){
        int m1 = method();
        System.out.println(m1);
    }

    public int method(){

        try{
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("肉蛋葱鸡");
        }

    }

    @Test
    public void test3(){

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();

//            int[] arr = new int[10];
//            System.out.println(arr[10]);

        } finally {
            System.out.println("芜湖起飞");
        }

    }

    @Test
    public void test2(){

        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1){
                System.out.println((char) data);
                data = fis.read();
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){

        try {
            String str = "123";
            str = "abc";
            int num = Integer.parseInt(str);//出现异常，进入catch

            System.out.println("ddd1");
        } catch (NumberFormatException e) {
//            System.out.println("出现类型转换异常");
            //String getMessage()
//            System.out.println(e.getMessage());
            //printStackTrace
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("出现异常");
        }

        System.out.println("ddd2");
    }
}
