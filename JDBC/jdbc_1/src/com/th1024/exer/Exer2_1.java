package com.th1024.exer;

import com.th1024.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author TuHong
 * @create 2021-03-09 22:38
 */
public class Exer2_1 {
    /*
    创建数据库表examstudent，并向表中添加数据
    实现1：插入一个新的student信息
    Type:4
    IDCard:422824195263214584
    ExamCard:200523164754006
    StudentName:张三
    Location:南宁
    Grade:78
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exer2_1 e = new Exer2_1();

        System.out.println("请输入考生的详细信息");
        System.out.print("Type:");
        int Type = scanner.nextInt();
        System.out.print("IDCard:");
        String IDCard = scanner.next();
        System.out.print("ExamCard:");
        String ExamCard = scanner.next();
        System.out.print("StudentName:");
        String StudentName = scanner.next();
        System.out.print("Location:");
        String Location = scanner.next();
        System.out.print("Grade:");
        int Grade = scanner.nextInt();

        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
        boolean isSucceed = e.update(sql, Type, IDCard, ExamCard, StudentName, Location, Grade);
        if (isSucceed){
            System.out.println("信息录入成功！");
        }else{
            System.out.println("信息录入失败！");
        }
    }

    public boolean update(String sql,Object... args){
        boolean isSucceed = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }

//            ps.execute();
//            System.out.println("信息录入成功！");
            int count = ps.executeUpdate();
            if(count > 0) isSucceed = true;
        } catch (Exception e) {
//            System.out.println("信息录入失败！");
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }
        return isSucceed;
    }
}
