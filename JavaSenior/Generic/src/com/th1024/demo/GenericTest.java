package com.th1024.demo;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1. JDK5新增的特性
 *
 * 2. 在集合中使用泛型
 *    ① 集合接口或集合类在JDK5时都修改为带泛型的结构
 *    ② 在实例化集合类时，可以指明具体的泛型类型
 *    ③ 指明之后，在集合类或接口中凡是定义接口类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型
 *    比如：add(E e) ---> 实例化之后：add(Integer e)
 *    ④ 注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，用包装类替代
 *    ⑤ 如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型
 *
 * 3. 如何自定义泛型结构：泛型类、泛型接口；泛型方法 --- GenericTest1.java
 *
 * 4. 泛型在继承方面的体现
 *
 * 5. 通配符的使用
 *
 *
 * @author TuHong
 * @create 2021-02-02 14:14
 */
public class GenericTest {

    /*
    通配符的使用
    通配符：?
    A与B为子父类关系，但是G<A>和G<B>不具备子父类关系，二者共同的父类为G<?>

    有限制条件的通配符
    ? extends A：G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类
    ? super A：G<? super A>可以作为G<A>和G<B>的父类，其中B是A的父类
     */
    @Test
    public void test6(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;
        Person p = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);

        //写入数据
//        list1.add(new Student());

        list2.add(new Student());
        list2.add(new Person());
    }
    @Test
    public void test5(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

//        print(list1);
//        print(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加：对于List<?>，不能向其内部添加数据
        //除了添加null之外
//        list.add("DD");
//        list.add("?");
        list.add(null);
        
        //获取（读取）：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }
    
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    泛型在继承方面的体现
    A与B为子父类关系，但是G<A>和G<B>不具备子父类关系

    补充：A与B为子父类关系，例如A是B的父类，则A<G>和B<G>也存在子父类关系，A<G>是B<G>的父类
     */
    @Test
    public void test4(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具备子父类关系
//        list1 = list2;

        AbstractList<String> list3 = null;
        List<String> list4 = null;
        ArrayList<String> list5 = null;
        list3 = list5;
        list4 = list5;
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //JDK7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---->" + value);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();//需要使用基本数据类型的包装类Integer
        list.add(78);
        list.add(76);
        list.add(88);
        list.add(90);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score : list){
//            //避免强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(88);
        list.add(90);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，有可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }
}
