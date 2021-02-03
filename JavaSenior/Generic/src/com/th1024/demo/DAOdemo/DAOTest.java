package com.th1024.demo.DAOdemo;

import org.junit.Test;

/**
 * @author TuHong
 * @create 2021-02-02 16:24
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
