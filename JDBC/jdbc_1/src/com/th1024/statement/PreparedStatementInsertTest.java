package com.th1024.statement;

import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用PreparedStatement实现批量数据操作
 *
 * update、delete本身就具有批量操作的效果
 * 此时的批量操作，主要是指批量插入
 *
 * 题目：
 * 向goods表中插入20000条数据
 *
 * 方式一：使用Statement
 * Connection conn = JDBCUtils.getConnection();
 * Statement st = conn.createStatement();
 * for(int i = 1;i <= 20000;i++){
 *     String sql = "insert into goods(name) values('name_" + i + "')";
 *     st.execute;
 * }
 *
 * @author TuHong
 * @create 2021-03-10 21:33
 */
public class PreparedStatementInsertTest {

    /*
    批量插入的方式二：使用PreparedStatement
    优化1：
    1. addBatch()、executeBatch()、clearBatch()
    2. MySQL服务器默认是关闭批处理的，需要一个参数，让MySQL开启批处理的支持
        ?rewriteBatchedStatements=true 写在配置文件的url后面
    3. 使用更新的MySQL驱动：mysql-connector-java-5.1.37-bin.jar
    优化2：设置连接不允许自动提交数据
     */
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();

            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1,"name_" + i);

                //1. “攒”sql
                ps.addBatch();
                if(i % 500 == 0){
                    //2. 执行Batch
                    ps.executeBatch();
                    //3. 清空Batch
                    ps.clearBatch();
                }
//                ps.execute();
            }
            //提交数据
            conn.commit();

            long end = System.currentTimeMillis();
            System.out.println("花费的时间为" + (end - start));//未优化：12427--优化：1334
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
}
