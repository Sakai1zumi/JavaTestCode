package com.oop.demo10;

//抽象的思维

//interface关键字，接口都需要有实现类
public interface UserService {

    //属性默认为静态常量
    public static final int age = 99;

    //接口中的所有定义其实都是抽象的 public abstract
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);


}
