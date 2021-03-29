package com.th1024.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author TuHong
 * @create 2021-03-23 20:29
 */
public class JdbcUtils {

    private static DataSource dataSource;

    static{
        try {
            Properties pros = new Properties();

            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            pros.load(is);

            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws Exception {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    public static void main(String[] args){
        try {
            System.out.println(getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    public static void closeConnection(Connection conn){
        DbUtils.closeQuietly(conn);
    }
}
