package com.th1024.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK8中时间API的测试
 *
 * @author TuHong
 * @create 2021-01-28 21:39
 */
public class JDK8DateTimeTest {

    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2021-01-28T22:29:34.992");
        System.out.println(parse);

        //方式二：本地化的格式。如：ofLocalizedDateTime(FormatStyle.LONG)

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        //ofLocalizedDate()
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

        //重点--方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-01-28 10:39:06");
        System.out.println(parse1);
    }

    /*
    Instant的使用
    类似于java.util.Date类
     */
    @Test
    public void test2(){
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli()：通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1611842735798L);
        System.out.println(instant1);
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用

    说明：
    1. LocalDateTime使用频率更高
    2. 类似于Calender类
     */
    @Test
    public void test1(){
        //now()：获取当前的日期，时间，日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年、月、日、时、分、秒，无偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 1, 28, 21, 46, 30);
        System.out.println(localDateTime1);

        //getXxx()--获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx()--设置相关属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);//2021-01-28T21:51:08.702
        System.out.println(localDateTime2);//2021-01-22T21:51:08.702--体现不可变性

        LocalDateTime localDateTime3 = localDateTime.withHour(9);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //plusXxx()--minusXxx()
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusDays(23);
        System.out.println(localDateTime);
        System.out.println(localDateTime5);
    }

}
