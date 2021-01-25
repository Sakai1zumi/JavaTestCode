package com.th1024.demo;

/**
 * 多线程的创建
 *
 * 方式一：继承于Tread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类中的run()方法
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 * 例子：遍历100以内的所有偶数
 *
 * 方式二：实现Runnable接口--开发中优先选择
 * 1. 定义子类，实现Runnable接口
 * 2. 子类中重写Runnable接口中的run方法
 * 3. 通过Thread类含参构造器创建线程对象
 * 4. 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中
 * 5. 调用Thread类的start方法：开启线程，调用Runnable子类接口中的run方法
 * 优点：
 * 1. 避免了单继承的局限性
 * 2. 多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源
 *
 * @author TuHong
 * @create 2021-01-23 14:05
 */
public class ThreadTest {

    public static void main(String[] args) {

        //3. 创建Thread类的子类的对象
        MyThread1 t1 = new MyThread1();
        //4. 通过此对象调用start()--分线程执行run()方法
        t1.start();
//        t1.run();//只是在主线程调用run方法

        //启动其他线程，不能通过已经start()的线程去执行
//        t1.start();//异常---IllegalThreadStateException
        //需重新创建一个线程的对象
//        MyThread1 t2 = new MyThread1();
//        t2.start();

        //主线程
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":"  + i);
            }
        }

        //3. 通过Thread类含参构造器创建线程对象
        //4. 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中
        MyThread2 myThread2 = new MyThread2();
        //5. 调用Thread类的start方法：开启线程，调用Runnable子类接口中的run方法
        Thread t3 = new Thread(myThread2);
        t3.start();
        //再启动一个线程，输出100以内的质数
        Thread t4 = new Thread(myThread2);
        t4.start();
        //创建匿名子类的方式创建线程
//        new Thread(new MyThread2()).start();

    }
}

//1. 创建一个继承于Thread类的子类
class MyThread1 extends Thread{

    //2. 重写Thread类中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":"  + i);
            }
        }
    }
}

//1. 定义子类，实现Runnable接口
class MyThread2 implements Runnable{

    //2. 子类中重写Runnable接口中的run方法
    @Override
    public void run() {
        //输出100以内的质数
        label:for (int i = 2; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    continue label;
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
