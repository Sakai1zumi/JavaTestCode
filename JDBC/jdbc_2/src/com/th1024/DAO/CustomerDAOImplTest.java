package com.th1024.DAO;

import com.th1024.bean.Customer;
import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


/**
 * @author TuHong
 * @create 2021-03-11 22:08
 */
public class CustomerDAOImplTest {

    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void insert() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Customer customer = new Customer(1, "三上悠亚", "ssyy@126.com", new Date(547554986097L));
        dao.insert(conn,customer);
        System.out.println("添加成功");
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void deleteById() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        dao.deleteById(conn,22);
        System.out.println("删除成功");
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void update() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Customer customer = new Customer(23, "桥本有菜", "123@qq.com", new Date(55609709909320L));
        dao.update(conn,customer);
        System.out.println("修改成功");
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void getCustomerById() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Customer customer = dao.getCustomerById(conn, 24);
        System.out.println(customer);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void getAll() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        List<Customer> list = dao.getAll(conn);
        list.forEach(System.out::println);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void getCount() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Long count = dao.getCount(conn);
        System.out.println(count);
        JDBCUtils.closeResource(conn,null);
    }

    @Test
    public void getMaxBirth() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Date maxBirth = dao.getMaxBirth(conn);
        System.out.println(maxBirth);
        JDBCUtils.closeResource(conn,null);
    }
}