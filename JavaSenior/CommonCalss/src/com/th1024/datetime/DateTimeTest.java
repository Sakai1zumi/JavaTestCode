package com.th1024.datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author TuHong
 * @create 2021-01-27 14:55
 */
public class DateTimeTest {

    /*
    Calender日历类(抽象类)的使用
     */
    @Test
    public void test5(){
        //1. 实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用器静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());//class java.util.GregorianCalendar

        //2. 常用方法
        //get()--获取常用的属性
        int days = calendar.get(Calendar.DAY_OF_MONTH);//这个月的第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-5);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()-- 日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()--Date-->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

    /*
    SimpleDateFormat：SimpleDateFormat对日期Date类的格式化和解析
    1. 两个操作
        格式化：日期-->字符串
        解析：字符串-->日期，格式化的逆过程
    2. SimpleDateFormat的实例化
     */
    @Test
    public void test3() throws ParseException {
        //实例化SimpleDateFormat：使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串-->日期，格式化的逆过程
        String str = "21-1-28 下午8:50";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //使用带参构造器--按照指定的方式格式化和解析
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);

        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        Date date2 = sdf1.parse("2020-12-03 11:23:45");
        System.out.println(date2);
    }
    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

    练习二："三天打鱼两天晒网" 1990-01-01 xxxx-xx-xx 打鱼？ 晒网？

    举例：2020-09-08  总天数？

    总天数 % 5 ==1、2、3  打鱼
    总天数 % 5 == 4、0  晒网

    总天数的计算？
    方式一：( date2.getTime() - date1.getTime() ) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-0101 --> 2019-12-31 + 2020-01-01 --> 2020-09-08
     */
    @Test
    public void test4() throws ParseException {
        String info = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(info);

        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

    }

    /*
    java.util.Date类
        ----java.sql.Date类
        
    1. 两个构造器的使用
        >构造器一：Date()--创建一个对应当前时间的Date对象
        >构造器二：Date(long date)--创建指定毫秒数的Date对象

    2. 两个方法的使用
        >toString()：显示当前的年、月、日、时、分、秒
        >getTime()：获取当前Date对象对应的毫秒数（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2(){
        //构造器一：Date()--创建一个对应当前时间的Date对象
        Date date1 = new Date();

        System.out.println(date1.toString());//Wed Jan 27 15:01:56 CST 2021
        System.out.println(date1.getTime());//1611730994364

        //构造器二：Date(long date)--创建指定毫秒数的Date对象
        Date date2 = new Date(1611730994364L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1611730994364L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);

    }

    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        long time = System.currentTimeMillis();

        System.out.println(time);

    }
}
