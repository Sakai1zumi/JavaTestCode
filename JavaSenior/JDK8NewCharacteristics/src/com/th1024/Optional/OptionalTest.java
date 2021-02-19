package com.th1024.Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的
 *
 * 常用方法：
 * ofNullable(T t)
 * orElse(T t)
 *
 * @author TuHong
 * @create 2021-02-19 17:16
 */
public class OptionalTest {

    /*
    Optional.of(T t)：创建一个Optional实例，t必须非空
    Optional.empty()：创建一个空的Optional实例
    Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //orElse(T t1)：如果当前Optional内部封装的t非空，则返回内部的t；如果t为空，则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("三上悠亚"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    //优化方法
    public String getGirlName1(Boy boy){
//        if(boy != null){
//            Girl girl = boy.getGirl();
//            if(girl != null){
//                return girl.getName();
//            }
//        }
//        return null;

        //使用Optional类
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        //此时boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("桥本有菜")));

        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        //此时girl1一定非空
        Girl girl1 = optionalGirl.orElse(new Girl("天使萌"));

        return girl1.getName();
    }

    @Test
    public void test3(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("明里紬"));
//        String girlName = getGirlName(boy);
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
}
