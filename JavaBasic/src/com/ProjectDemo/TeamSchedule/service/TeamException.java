package com.ProjectDemo.TeamSchedule.service;

/**
 * @Description 自定义异常类
 * @Author TuHong
 * @Date 2021/1/22 14:29
 * @Version 1.0
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -3387543993124229948L;

    public TeamException(){

    }

    public TeamException(String msg){
        super(msg);
    }
}
