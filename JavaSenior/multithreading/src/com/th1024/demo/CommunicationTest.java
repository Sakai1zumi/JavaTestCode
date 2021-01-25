package com.th1024.demo;

/**
 * 线程通信的例子：使用两个线程打印1-100。线程1，线程2，交替打印
 *
 * 涉及到的三个方法：
 * wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就会唤醒优先级高的线程
 * notifyAll()：一旦执行此方法，就会唤醒所有被wait一个线程
 *
 * 说明：
 * 1. wait()、notify()、notifyAll()都必须使用在同步代码块或者同步方法之中
 * 2. wait()、notify()、notifyAll()的调用者必须是同步代码块或者同步方法中的同步监视器，
 *   否则，会出现IllegalMonitorStateException异常
 * 3. wait()、notify()、notifyAll()均定义在java.lang.Object类中
 *
 * 面试题：sleep()和wait()的异同？
 * 1. 相同点：一旦执行方法，都可以使当前线程进图阻塞状态
 * 2. 不同点：
 *      1）两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *      2）调用的要求不同：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块或者同步方法中
 *      3）是否释放同步监视器：两个方法如均是使用在同步代码块或者同步方法中，sleep()方法不会释放同步监视器，wait()会释放同步监视器
 *
 * @author TuHong
 * @create 2021-01-25 14:31
 */

class Number implements Runnable{

    private int num = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        for (;;){

            synchronized (obj) {

                obj.notify();

                if(num <= 100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "输出" + num);
                    num++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }

        }

    }
}
public class CommunicationTest {

    public static void main(String[] args) {

        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
