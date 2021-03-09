package com.th1024.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author TuHong
 * @create 2021-03-08 23:26
 */
public class ConnectionTest {

    /*获取连接的方式
    将数据库需要的四个基本信息声明在配置文件中，通过读取配置文件的方式获取连接
    1. 实现了数据与代码分离--解耦
    2. 如果需要修改配置文件信息，可以避免程序重新打包
     */
    @Test
    public void getConnection() throws Exception {
        //1. 读取配置文件中的4个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2. 加载驱动
        Class.forName(driverClass);

        //3. 获取链接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
