package com.th1024.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author TuHong
 * @create 2021-04-19 11:11
 */
public class JdbcTemplateTest {

    @Test
    public void test1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean1.xml");

        DataSource dataSource = ioc.getBean(DataSource.class);

        System.out.println(dataSource);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
    @Test
    public void test2() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean1.xml");

        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        String sql = "update employee set salary=? where emp_id=?";

        int update = jdbcTemplate.update(sql, 13000.00, 5);

        System.out.println("影响了" + update + "行");
    }

}
