package com.th1024.transaction;

import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 数据库事务
 * 事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态
 *      一组逻辑操作单元：一个或多个DML操作
 *
 * 事务处理的原则：保证所有事物都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式
 *
 * @author TuHong
 * @create 2021-03-11 20:31
 */
public class TransactionTest {
    /*
    针对数据表user_table：AA给BB转账100
    update user_table set balance = balance - 100 where user = 'AA'
    update user_table set balance = balance + 100 where user = 'BB'
     */

    //考虑数据库事务之后的转账操作
    @Test
    public void testUpdateWithTx() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //取消数据的自动提交
            conn.setAutoCommit(false);

            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn,sql1,"AA");

//            //模拟网络阻塞
//            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn,sql2,"BB");

            System.out.println("转账成功");
            //2. 提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //3. 回滚数据
            try {
                if(conn != null)
                    conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    //通用的增删改操作（考虑事务）
    public int update(Connection conn,String sql,Object... args) {

        PreparedStatement ps = null;
        try {
            //1. 预编译sql语句，返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
            //2. 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            //3. 执行
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4. 资源的关闭
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }

    @Test
    public void testTxSelect() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        //获取当前数据库的隔离级别
//        System.out.println(conn.getTransactionIsolation());
        //设置当前数据库的隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        //取消自动提交数据
        conn.setAutoCommit(true);
        String sql = "select user,password,balance from user_table where user = ?";

        User cc = getInstance(conn, User.class, sql, "CC");
        System.out.println(cc);
    }

    @Test
    public void testTxUpdate() throws Exception {
        Connection conn = JDBCUtils.getConnection();

        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update(conn,sql,1500,"CC");

        Thread.sleep(15000);
        System.out.println("修改结束");
    }

    //通用的查询操作（考虑事务），返回数据表中的一条记录
    public <T> T getInstance(Connection conn,Class<T> tClass,String sql,Object... args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                T t = tClass.newInstance();
                //处理结果集的一行数据的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = tClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }
}
