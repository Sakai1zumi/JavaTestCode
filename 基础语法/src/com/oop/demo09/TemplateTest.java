package com.oop.demo09;

/*
抽象类的应用：模板方法的设计模式
 */

public class TemplateTest {

    public static void main(String[] args) {

        SubTemplate subTemplate = new SubTemplate();

        subTemplate.spendTime();

    }
}

abstract class Template{

    //计算某段代码所花费的时间
    public void spendTime(){

        long start = System.currentTimeMillis();

        this.code();//不确定的部分、易变的部分

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));

    }

    public abstract void code();
    
}

class SubTemplate extends Template{

    @Override
    //输出1000以内的质数
    public void code() {

        boolean isFlag = true;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.print(i + "\t");
            }
            isFlag = true;//每次循环末尾重置isFlag
        }

    }
}
