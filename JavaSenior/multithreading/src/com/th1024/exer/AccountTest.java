package com.th1024.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 分析：
 * 1. 是否是多线程问题？ 是，两个储户线程
 * 2. 是否有共享数据？ 有，账户（或账户余额）
 * 3. 是否有线程安全问题？ 有
 * 4. 如何解决线程安全问题？ 同步机制
 *
 * @author TuHong
 * @create 2021-01-25 14:04
 */

class BankAccount {

    private double balance;
    private ReentrantLock lock = new ReentrantLock();

    public BankAccount(double balance){
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt){

        lock.lock();
            if(amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "存款成功！余额为：" + balance);
            }
        lock.unlock();
    }
}


class Customer extends Thread{

    private BankAccount acct;

    public Customer(BankAccount acct){
        this.acct = acct;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {

    public static void main(String[] args) {

        BankAccount acct = new BankAccount(0);

        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}