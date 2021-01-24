package com.th1024.multiplethreads.ThreadDemo;

/**
 * 例子：创建三个窗口卖票，总票数为100张
 *
 * 方式一：使用继承Thread类的方式
 * 存在线程安全问题
 *
 * 方式二：使用实现Runnable接口的方式
 * 存在线程安全问题
 *
 *
 * @author TuHong
 * @create 2021-01-24 13:18
 */

class Window1 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {

        while(true){
            if(ticket > 0){
                System.out.println(getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}

class Window2 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {

        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
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
        t3.setName("窗口二");

        t1.start();
        t2.start();
        t3.start();
    }
}
