package com.th1024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author TuHong
 * @create 2021-04-20 22:37
 */
@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx(){
        //可以设置事务的传播行为，控制该事务是否和上层的大事务共用一个事务
        bookService.checkout("Tom","ISBN-001");

        bookService.updatePrice("ISBN-001",666);
    }

}
