package com.th1024.dao;

import com.th1024.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author TuHong
 * @create 2021-05-31 9:46
 */
@Repository
public class BookDao extends BaseDao<Book>{
    @Override
    public void save() {
        System.out.println("BookDao保存图书");
    }
}
