package com.th1024.exer;

import com.th1024.bean.Student;
import com.th1024.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @author TuHong
 * @create 2021-03-09 23:01
 */
public class Exer2_2 {
    /*
    创建数据库表examstudent，并向表中添加数据
    实现2：输入身份证号或准考证号可以查询到学生的基本信息
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Exer2_2 e = new Exer2_2();

        System.out.println("请选择您要输入的类型");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号");
        String selection = scanner.next().toUpperCase();

        String sql = null;
        Student student = null;
        switch(selection){
            case "A" :
                sql = "select FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where ExamCard = ?";
                System.out.println("请输入准考证号：");
                long examCard = scanner.nextLong();
                student = e.query(Student.class, sql, examCard);
                if(student == null){
                    System.out.println("查无此人！请重新进入程序");
                }else{
                    System.out.println("=========查询结果=========");
                    System.out.println(student);
                }

                break;
            case "B":
                sql = "select FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade from examstudent where IDCard = ?";
                System.out.println("请输入身份证号：");
                long idCard = scanner.nextLong();
                student = e.query(Student.class, sql, idCard);
                if(student == null){
                System.out.println("查无此人！请重新进入程序");
                }else{
                System.out.println("=========查询结果=========");
                System.out.println(student);
                }
                break;
            default:
                System.out.println("您的输入有误！请重新进入程序");
                break;
        }

    }

    public <T> T query(Class<T> tClass, String sql, Object... args) {
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
                T t = tClass.newInstance();
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
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
