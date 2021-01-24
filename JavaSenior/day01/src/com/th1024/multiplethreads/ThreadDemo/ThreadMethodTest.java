package com.th1024.multiplethreads.ThreadDemo;

/**
 * 测试Thread中的常用方法：
 * 1. start()：启动当前线程，调用当前线程的run()
 * 2. run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread()：静态方法，返回当前代码的线程
 * 4. getName()：获取当前线程的名字
 * 5. setName()：设置当前线程的名字
 * 6. yield()：释放当前cpu的执行权
 * 7. join()：在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b完全执行完之后，
 *            线程a才会结束阻塞状态
 * 8. sleep(long millis)：让当前线程“睡眠”指定的毫秒。在这段时间内，线程是阻塞状态
 * 9. isAlive()：判断当前线程是否存活
 *
 * 线程的优先级：
 * 1. MAX_PRIORITY ：10
 *    MIN_PRIORITY：1
 *    NORM_PRIORITY：5 -->默认的优先级
 * 2. 获取和设置当前线程的优先级
 *    getPriority()：获取线程的优先级
 *    setPriority(int p)：设置线程的优先级
 *
 *    说明：高优先级的线程要抢占低优先级线程cpu的执行权，但是高优先级的线程只是概率上较高被先执行
 *    并不是高优先级的线程一定会被先执行
 *
 * @author TuHong
 * @create 2021-01-24 10:50
 */
public class ThreadMethodTest {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("Thread1");

        //给分线程命名
//        t1.setName("线程1");

        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        //设置主线程的优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + "priority-"
                        + Thread.currentThread().getPriority() + " " + i);
            }

//            if(i == 20){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        //判断分线程是否存活
//        System.out.println(t1.isAlive());
    }
}

class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){

//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + "priority-"
                        + Thread.currentThread().getPriority() + " " + i);
            }

//            if(i % 20 == 0){
//                yield();
//            }
        }
    }

    public Thread1(String name){
        super(name);
    }
}
