package com.th1024.statement;

import com.th1024.bean.Customer;
import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author TuHong
 * @create 2021-03-09 13:16
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Customer customer = queryForCustomer(sql, 13);
        System.out.println(customer);

        sql = "select name,email from customers where name = ?";
        Customer customer1 = queryForCustomer(sql, "周杰伦");
        System.out.println(customer1);
    }

    /*
    针对customers表的通用查询操作
     */
    public Customer queryForCustomer(String sql,Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Customer customer = new Customer();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);
                    //给customer对象指定的columnName属性赋值为columnValue：通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer,columnValue);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps,rs);
        }
        return null;
    }


    @Test
    public void testQuery1() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1,1);
        //执行，并返回结果集
        ResultSet resultSet = ps.executeQuery();
        //处理结果集
        if(resultSet.next()){//next()：判断结果集的下一条是否有数据，如果有数据返回true，并指针下移，如果没有数据返回false，指针不下移
            //获取当前这条数据的各个字段值
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);
            //将数据封装为一个对象
            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);
            //关闭资源
            resultSet.close();
            ps.close();
            connection.close();
        }
    }

}
