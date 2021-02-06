package com.th1024.demo;

import java.io.Serializable;

/**
 * Person需满足一定的要求才可序列化
 *
 * 1. 需实现接口Serializable
 *
 * 2. 需当前类提供一个全局常量：serialVersionUID
 *
 * 3. 除了当前Person类需实现Serializable接口之外，还必须保证其内部所有属性是可序列化的
 *    默认情况下，基本数据类型和String可序列化
 *
 * 4. 补充：ObjectOutputStream和ObjectInputStream不能序列化 static 和 transient 修饰的成员变量
 *
 * 5. 序列化机制
 *      对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点
 *      当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 *
 * @author TuHong
 * @create 2021-02-05 14:32
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 3434567890232L;

    private String name;
    private int age;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable{

    public static final long serialVersionUID = 3434567567232L;

    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
