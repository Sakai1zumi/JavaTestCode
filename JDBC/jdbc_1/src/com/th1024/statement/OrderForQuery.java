package com.th1024.statement;

import com.th1024.bean.Order;
import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author TuHong
 * @create 2021-03-09 14:28
 */
public class OrderForQuery {

    /*
    针对表的字段名与类的属性名不相同的情况：
    1. 必须在声明sql语句时，使用类的属性名来作为要查询字段的别名
    2. 使用ResultSetMetaData时，需使用getColumnLabel()来替换getColumnName()，获取列的别名
       说明：若sql语句中没有给字段起别名，getColumnLabel()获取的就是列名
     */

    @Test
    public void testOrderQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);
    }

    /*
    通用的针对order表的查询操作
     */
    public Order orderForQuery(String sql,Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
