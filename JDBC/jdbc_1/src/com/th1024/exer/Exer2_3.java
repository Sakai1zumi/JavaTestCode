package com.th1024.exer;

import com.th1024.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @author TuHong
 * @create 2021-03-09 23:48
 */
public class Exer2_3 {

    /*
    创建数据库表examstudent，并向表中添加数据
    实现3：完成学生信息的删除功能
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exer2_3 e = new Exer2_3();

        System.out.println("请输入学生的考号：");
        String examCard = scanner.next();

        String sql = "delete from examstudent where ExamCard = ?";
        boolean isDelete = e.update(sql, examCard);
        if(isDelete){
            System.out.println("删除成功！");
        }else{
            System.out.println("查无此人，请重新输入！");
        }
    }

    public boolean update(String sql,Object...args){
        boolean isDelete = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
//            String querySql = "select ExamCard from examstudent where ExamCard = ?";
//            ps = conn.prepareStatement(querySql);
//
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1,args[i]);
//            }
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
                ps = conn.prepareStatement(sql);

                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1,args[i]);
                }

//                ps.execute();
                int count = ps.executeUpdate();
                if(count > 0) isDelete = true;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return isDelete;
    }
}
