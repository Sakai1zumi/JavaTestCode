package com.th1024.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author TuHong
 * @create 2021-04-19 15:54
 */
@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //1. 修改余额
    public void updateBalance(String username,int price){
        String sql = "UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,price,username);
    }

    //2. 按照图书的ISBN获取某本图书的价格
    public int getPrice(String isbn){
        String sql = "SELECT price FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    //3. 修改库存，每次将书本库存减少一
    public void updateStock(String isbn){
        String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);
    }

    //4. 修改图书价格
    public void updatePrice(String isbn,int price){
        String sql = "update book set price=? where isbn=?";

        jdbcTemplate.update(sql,price,isbn);
    }
}
