package com.th1024.StreamAPI;

import com.th1024.Lambda1.Employee;
import com.th1024.Lambda1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，集合关注的是数据的存储
 *
 * 2. 特点
 *  ① Stream自己不会存储元素
 *  ② Stream不会改变元对象，相反，它们会返回一个持有结果的新Stream
 *  ③ Stream操作是延迟执行的，这意味着它们会等到需要结果的时候才执行
 *
 * 3. Stream执行流程
 *  ① Stream的实例化
 *  ② 一系列中间操作（过滤，映射、...）
 *  ③ 终止操作
 *
 * 4. 说明
 *  ① 一个中间操作链，对数据源的数据进行处理
 *  ② 一旦执行终止操作，就执行中间操作链，并产生结果，之后不会再被使用
 *
 * 测试Stream的实例化
 *
 * @author TuHong
 * @create 2021-02-19 12:05
 */
public class StreamAPITest {
    //创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> Stream()：返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream()：返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr1 = new int[]{1,2,3,4,5};
        //调用Arrays类的static <T> Stream<T> stream (T[] array)：返回一个流
        IntStream stream1 = Arrays.stream(arr1);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1001,"Jerry");
        Employee[] arr2 = new Employee[]{e1,e2};

        Stream<Employee> stream2 = Arrays.stream(arr2);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }
}
