package com.th1024.demo;

/**
 * 例子：创建三个窗口卖票，总票数为100张
 *
 * 方式一：使用继承Thread类的方式
 * 存在线程安全问题
 *
 * 方式二：使用实现Runnable接口的方式
 * 存在线程安全问题
 *
 * 1. 问题：重票和错票
 * 2. 原因：某个线程进行操作共享数据时，还没执行完，其它线程就参与进来也进行了操作
 * 3. 解决：当一个线程操作共享数据时，其它线程不能参与进来，直到线程操作完成时，其它线程才可以操作，
 *      即使该线程出现阻塞，其它线程也不能参与
 * 4. 方式：同步机制
 *    优点：解决了线程不安全问题
 *    缺点：操作同步代码时，只能有一个线程参与，相当于单线程，效率低
 *
 * 方式一：同步代码块
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *      }
 * 说明：1. 操作共享数据的代码，即为需要被同步的代码
 *      2. 共享数据：多个线程共同操作的变量
 *      3. 同步监视器。俗称：锁。任何一个类的对象都可以充当锁
 *         要求：多个线程必须拥有同一个监视器对象
 *
 * 方式二：同步方法
 *      如果操作共享数据的代码完整地声明在一个方法中，不妨将这个方法声明为同步方法
 *  说明：1. 同步方法仍然涉及到同步监视器，只是不需要显式声明
 *       2. 非静态的同步方法，同步监视器是：this
 *          静态的同步方法，同步监视器是：当前类本身
 *      3. 慎用this充当同步监视器
 *
 * @author TuHong
 * @create 2021-01-24 13:18
 */

class Window1 extends Thread{

    private static int ticket = 100;
    static Object obj = new Object();//声明为静态，每个对象共享一个静态变量

    @Override
    public void run() {

        while(ticket > 0){
        //while(true) {
            //同步代码块解决继承Thread类方式的线程安全问题
//            synchronized(Window1.class){//使用Window1类作为对象，只会加载一次  //synchronized (obj) {//不能使用this，Window1的对象不唯一
//                if (ticket > 0) {
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
            sell();
//            }
        }
    }

    private static synchronized void sell(){//同步监视器：Window1.class
    //private synchronized void sell(){//同步监视器：w1，w2，w3
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

class Window2 implements Runnable{

    private int ticket = 100;
//    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {

        while(ticket > 0){
        //while(true) {
            //同步代码块解决实现Runnable接口方式的线程安全问题
//            synchronized(this){//this代表唯一的Window2的对象  //synchronized (dog) {
//                if (ticket > 0) {
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
            sell();
//            }
        }
    }

    private synchronized void sell(){//同步监视器：this

        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest {

    public static void main(String[] args) {

//        Window1 w1 = new Window1();
//        Window1 w2 = new Window1();
//        Window1 w3 = new Window1();
//
//        w1.setName("窗口一");
//        w2.setName("窗口二");
//        w3.setName("窗口三");
//
//        w1.start();
//        w2.start();
//        w3.start();

        Window2 window2 = new Window2();

        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window2);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

//class Dog{
//
//}