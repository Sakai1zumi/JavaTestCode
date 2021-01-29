package com.th1024.enumdemo;

/**
 * 使用enum关键字定义枚举类
 * 默认继承于class java.lang.Enum
 *
 * @author TuHong
 * @create 2021-01-29 11:28
 */
public class SeasonTest1 {

    public static void main(String[] args) {

        Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer);

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("**************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        System.out.println("****************************");
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter = Season1.valueOf("WINTER1");//IllegalArgumentException
        System.out.println(winter);
        winter.show();

    }
}

interface info{
    void show();
}

//使用enum关键字枚举类
enum Season1 implements info{
    //1. 提供当前枚举类的多个对象，多个对象之间用','隔开，末尾对象';'结束
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？春天在哪里？");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天夏天悄悄过去，留下小秘密");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("就让秋天带走我的思念，带走我的泪");
        }
    },
    WINTER ("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("雪花飘飘北风萧萧");
        }
    };

    //1. 声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2. 私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4. 其它诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("季节");
//    }

    //5. 其他诉求2：输出枚举类对象的信息
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
