package com.th1024.multiplethread;

/**
 *
 * 多线程的创建，方式一：继承于Tread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类中的run()方法
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 * 例子：遍历100以内的所有偶数
 *
 * @author TuHong
 * @create 2021-01-23 14:05
 */
public class ThreadTest {

    public static void main(String[] args) {

        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4. 通过此对象调用start()--分线程执行run()方法
        t1.start();
//        t1.run();//只是在主线程调用run方法

        //启动其他线程，不能通过已经start()的线程去执行
//        t1.start();//异常---IllegalThreadStateException
        //需重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();

        //主线程
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + i + "*");
            }
        }
    }
}

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread{

    //2. 重写Thread类中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
