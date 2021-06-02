package com.th1024.service;

import com.th1024.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author TuHong
 * @create 2021-05-31 9:55
 */
public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void save(){
        System.out.println("自动注入的dao：" + baseDao);
        baseDao.save();
    }
}
