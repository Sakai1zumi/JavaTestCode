package com.th1024.demo;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author TuHong
 * @create 2021-01-25 11:20
 */
public class BankTest {
}

class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance() {
        // public static synchronized Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
