package com.th1024.StreamAPI;

import com.th1024.Lambda1.Employee;
import com.th1024.Lambda1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author TuHong
 * @create 2021-02-19 16:31
 */
public class StreamAPITest2 {
    //1. 匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p) -- 检查是否匹配所有元素
        //练习：是否所有的员工年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        //anyMatch(Predicate p) -- 检查是否至少匹配一个元素
        //练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);
        //noneMatch(Predicate p) -- 检查是否没有匹配的元素
        //练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        //findFirst() -- 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findAny() -- 返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
        //count() -- 返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        //max(Comparator c) -- 返回流中的最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);
        //min(Comparator c) -- 返回流中的最小值
        //练习：返回最低工资的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        //forEach(Consumer c) -- 内部迭代
        employees.forEach(System.out::println);
    }

    //2. 归约
    @Test
    public void test2(){
        //reduce(T identity,BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值，返回T
        //练习1：计算1-10的自然数之和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        //reduce(BinaryOperator) -- 可以将流中的元素反复结合起来，得到一个值，返回Optional<T>
        //练习2：计算公司所有员工工资总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
//        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        Optional<Double> sumSalary = salaryStream.reduce((d1,d2) -> d1 + d2);
        System.out.println(sumSalary);
    }

    //3. 收集
    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();
        //collect(Collector c) -- 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中的元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);

    }

}
