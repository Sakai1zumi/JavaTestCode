package com.th1024.exer;

import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author TuHong
 * @create 2021-03-09 22:28
 */
public class Exer1 {

    @Test
    public void test() throws ParseException {
        String sql = "insert into customers(name,email,birth) values (?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse("999-10-01");
        boolean isSucceed = insert(sql, "姜子牙", "jiangzy@126.com", new Date(date.getTime()));

        if (isSucceed){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }

    /*
    从控制台向数据库的表customers中插入一条数据
     */
    public boolean insert(String sql,Object... args){
        boolean isSucceed = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            /*
            ps.execute();
            如果执行的时查询操作，有返回结果，则此方法返回true
            如果执行的是增、删、改操作，没有返回结果，则此方法返回false
             */
//            ps.execute();
            int count = ps.executeUpdate();
            if(count > 0) isSucceed = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn,ps);
        }
        return isSucceed;
    }
}
