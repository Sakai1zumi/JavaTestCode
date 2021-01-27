package com.th1024.exer;

/**
 * @author TuHong
 * @create 2021-01-26 10:22
 */
public class BankTest {
}

class Bank{

    private Bank(){}//私有化构造器

    private static Bank instance = null;//私有的静态变量

    public static Bank getInstance() {//公共的静态方法
        if(instance == null) {
            synchronized (Bank.class){
                instance = new Bank();
            }
        }

        return instance;
    }
}
