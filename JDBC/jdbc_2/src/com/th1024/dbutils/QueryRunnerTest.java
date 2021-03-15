package com.th1024.dbutils;

import com.th1024.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;

/**
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库,封装了针对于数据库的增删改查操作
 *
 * @author TuHong
 * @create 2021-03-12 21:34
 */
public class QueryRunnerTest {

    //测试插入
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection1();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "枫花恋", "fhl@qq.com", "1999-01-01");
            System.out.println("添加了" + insertCount + "行数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    //测试查询
    @Test
    public void testQuery1(){

    }
}
