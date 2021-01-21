package com.exception.demo01;

/*
自定义异常类

1. 继承现有的异常结构：Exception、RuntimeException
2. 提供全局常量：serialVersionUID
3. 提供重载的构造器


 */

//继承异常类
public class MyException extends RuntimeException{

    static final long serialVersionUID = -7034897190745666939L;

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }

}
