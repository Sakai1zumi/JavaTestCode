package com.th1024.statement;

import com.th1024.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * 使用PreparedStatement实现对表的操作，替换statement解决sql注入问题
 *
 * @author TuHong
 * @create 2021-03-09 10:08
 */
public class PreparedStatementTest {

    public static void main(String[] args){
        PreparedStatementTest pst = new PreparedStatementTest();
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String user = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        String sql = "SELECT `user`,`password` FROM user_table WHERE USER = ? AND PASSWORD = ?";
        User returnUser = pst.getInstance(User.class, sql, user, password);
        if(returnUser != null){
            System.out.println("登陆成功");
            System.out.println(returnUser);
        }else{
            System.out.println("用户名不存在或者密码错误");
        }
    }


    /*
    针对不同的表的通用的查询操作
     */
    public <T> T getInstance(Class<T> tClass,String sql,Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1,args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()){
                T t = tClass.newInstance();
                //处理结果集一行数据中的每一个列
                for(int i = 0; i < columnCount; i++){
                    //获取列值
                    Object columnValue = resultSet.getObject(i + 1);

                    //获取每个列的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性，赋值为columnValue：通过反射
                    Field field = tClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
