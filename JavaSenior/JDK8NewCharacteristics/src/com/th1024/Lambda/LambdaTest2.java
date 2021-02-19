package com.th1024.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>   boolean test(T t)
 *
 * @author TuHong
 * @create 2021-02-18 15:53
 */
public class LambdaTest2 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费" + aDouble + "元");
            }
        });

        happyTime(400, money -> System.out.println("消费" + money + "元"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","上海");

        List<String> filterStrings = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrings);

        List<String> filterStrings1 = filterString(list, s -> s.contains("京"));

        System.out.println(filterStrings1);
    }

    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterString = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterString.add(s);
            }
        }

        return filterString;
    }
}
