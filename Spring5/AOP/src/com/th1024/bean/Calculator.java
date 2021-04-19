package com.th1024.bean;

/**
 * 接口一般不加载到容器中
 * 实际上可以加载，接口加载至容器中并不创建对象，而是意味着IOC容器中可能会有这种类型的组件
 *
 * @author TuHong
 * @create 2021-04-16 14:06
 */
public interface Calculator {

    int add(int i,int j);
    int sub(int i,int j);
    int mul(int i,int j);
    int div(int i,int j);
}
