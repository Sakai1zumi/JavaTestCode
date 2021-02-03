package com.th1024.demo.DAOdemo;

import java.util.List;

/**
 * DAO:data(base) access object
 *
 * @author TuHong
 * @create 2021-02-02 16:10
 */
public class DAO <T>{//表的共性操作的DAO

    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){

        return false;
    }
    //修改一条记录
    public void update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){

        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){

        return null;
    }

    //泛形方法
    public <E> E getValue(){

        return null;
    }
}
