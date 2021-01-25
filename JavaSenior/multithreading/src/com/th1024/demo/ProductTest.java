package com.th1024.demo;

/**
 * 线程通信的应用--经典例题：生产者/消费者问题
 *
 * 生产者(Producer)将产品交给店员 (Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费等一下，如果店中有产品了在通知消费者来取走产品
 *
 * 分析：
 * 是否是多线程问题？ 是：生产者线程，消费者线程
 * 是否有线程安全问题？ 是，店员（或产品）
 * 如何解决线程安全问题？ 同步机制，三种方法
 * 是否涉及到线程的通信？ 是
 *
 *
 * @author TuHong
 * @create 2021-01-25 15:12
 */

class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "生产产品");

        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }


}

class Consumer extends Thread{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "消费产品");

        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }


}

public class ProductTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者");

        p1.start();
        c1.start();
    }
}
