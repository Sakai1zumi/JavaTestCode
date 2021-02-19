package com.th1024.Lambda1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *     和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *     抽象方法的返回值类型即为构造器所属的类
 *
 * 二、数组引用
 *     将数组看作是特殊的类，使用方法与构造器引用一致
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        sup.get();

        System.out.println("******************");

        Supplier<Employee> sup1 = () -> new Employee();
        sup1.get();

        System.out.println("******************");

        Supplier<Employee> sup2 = Employee::new;
        sup2.get();
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1 = id -> new Employee(id);
        Employee emp1 = func1.apply(1001);
        System.out.println(emp1);

        System.out.println("********************");

        Function<Integer,Employee> func2 = Employee :: new;
        Employee emp2 = func2.apply(1002);
        System.out.println(emp2);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1 = (id,name) -> new Employee(id,name);
        Employee emp1 = func1.apply(1001, "Tom");
        System.out.println(emp1);

        System.out.println("*********************");

        BiFunction<Integer,String,Employee> func2 = Employee::new;
        Employee emp2 = func2.apply(1002, "Jerry");
        System.out.println(emp2);

    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(10);
        System.out.println(Arrays.toString(arr1));

        System.out.println("********************");

        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(5);
        System.out.println(Arrays.toString(arr2));

    }
}
