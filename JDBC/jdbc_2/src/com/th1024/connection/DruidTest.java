package com.th1024.connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.th1024.DAO.CustomerDAOImpl;
import com.th1024.bean.Customer;
import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author TuHong
 * @create 2021-03-12 16:24
 */
public class DruidTest {

    @Test
    public void testConnection() throws Exception {
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    @Test
    public void testConnection1() throws Exception {
        Connection conn1 = JDBCUtils.getConnection1();
        CustomerDAOImpl dao = new CustomerDAOImpl();
        Customer customer = dao.getCustomerById(conn1, 24);
        System.out.println(customer);
    }
}
