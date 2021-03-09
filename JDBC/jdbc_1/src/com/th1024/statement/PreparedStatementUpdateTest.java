package com.th1024.statement;

import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author TuHong
 * @create 2021-03-09 11:30
 */
public class PreparedStatementUpdateTest {

    //测试增删改操作
    @Test
    public void testCommonUpdate(){
        String sql = "DELETE FROM customers WHERE `name` = ?";
        update(sql,"姜子牙");
    }

    //通用的增删改操作
    public void update(String sql,Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 预编译sql语句，返回PreparedStatement实例
            ps = connection.prepareStatement(sql);
            //3. 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            //4. 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //修改customers表中的一条记录
    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 预编译sql语句
            String sql = "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);
            //3. 填充占位符
            ps.setObject(1,"姜子牙");
            ps.setObject(2,20);
            //4. 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1. 读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            //2. 加载驱动
            Class.forName(driverClass);

            //3. 获取连接
            connection = DriverManager.getConnection(url, user, password);

            //4. 预编译sql语句，返回PreparedStatement实例
            String sql = "insert into customers(name,email,birth) values(?,?,?)";//?--占位符
            ps = connection.prepareStatement(sql);

            ps.setObject(1,"哪吒");
            ps.setObject(2,"nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setObject(3,new Date(date.getTime()));
            //6. 执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //7. 资源的关闭
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



    }
}
