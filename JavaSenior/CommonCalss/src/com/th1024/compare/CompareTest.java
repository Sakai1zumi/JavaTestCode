package com.th1024.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1. 说明：Java中的对象，正常情况下，只能进行比较：== 或 ！=
 *    开发场景中需要对多个对象进行排序，即需要比较对象的大小
 *
 * 2. Comparable接口与Comparator接口的对比：
 *      Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置均可比较大小
 *      Comparator接口属于临时性的比较
 *
 * @author TuHong
 * @create 2021-01-28 23:05
 */
public class CompareTest {

    /*
    Comparable接口的使用举例：自然排序
    1. String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，可比较两个对象的大小
    2. String、包装类重写compareTo(obj)方法，进行了从小到大的排序
    3. 重写compareTo()的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零
    4. 对于自定义类如需要排序，可实现Comparable接口，重写compareTo()，方法中指明排序方式
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口的使用：定制排序
    1. 背景
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前操作，
    那么可以考虑使用Comparator的对象来排序
    2. 重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
        如果方法返回正整数，则表示o1大于o2
        如果返回0，表示相等
        如果返回负整数，表示o1小于o2
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};

        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                    if(o1 instanceof String && o2 instanceof String){
                        String s1 = (String) o1;
                        String s2 = (String) o2;

                        return -s1.compareTo(s2);
                    }
//                return 0;
                    throw new RuntimeException("输入数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){

        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);
        arr[5] = new Goods("microsoftMouse",50);

        Arrays.sort(arr, new Comparator() {
            //指明排序方式：先按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;

                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
