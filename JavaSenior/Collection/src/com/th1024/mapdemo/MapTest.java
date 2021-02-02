package com.th1024.mapdemo;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构
 * Map：双列数据，存储key-value对的数据
 *      HashMap：作为Map的主要实现类，线程不安全的，效率高；可存储null的key和value
 *          LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                        原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个元素和后一个元素
 *                        对于频繁的遍历操作，此类执行效率高于HashMap
 *      TreeMap：保证按照添加的key-value对进行排序，实现排序遍历；此时考虑key的自然排序或定制排序
 *              底层使用红黑树
 *      Hashtable：作为古老实现类，线程安全的，效率低；不能存储null的key和value
 *          Properties：常用来处理配置文件。key和value都是String类型
 *
 * 面试题
 * 1. HashMap底层实现原理？
 * 2. HashMap和Hashtable的异同？
 * 3. CurrentHashMap与Hashtable的异同？（暂时不讲）
 *
 * 二、Map结构的理解
 *  Map中的key：无序的、不可重复的，使用Set存储所有的key  --->key所在的类需要重写equals()和hashCode()（以HashMap为例）
 *  Map中的value：无序的、可重复的，使用Collection存储所有的value  --->value所在类要重写equals()
 *  一个键值对：key-value构成一个Entry对象
 *  Map中的entry：无序的、不可重复的，使用Set存储所有的key
 *
 * 三、HashMap的底层实现原理
 *    JDK7为例
 *    HashMap map = new HashMap();
 *    实例化之后，底层创建了长度是16的一维数组Entry[] table
 *    map.put(key1,value1);
 *    首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算之后，得到在Entry数组中的存放位置
 *    如果此位置上的数据为空，此时key1-value1添加成功 ----情况1
 *    如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表的形式存在）），比较key1和已经存在的一个或多个哈希值
 *      如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功 ----情况2
 *      如果key1的哈希值和已经存在的某一个数据（key2-value2）的哈希值相同，继续调用key1所在类的equals()比较
 *          如果equals()返回false，此时key1-value1添加成功 ----情况3
 *          如果equals()返回true，使用value1替换value2
 *      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的形式存储
 *
 *    在不断的添加过程中，当超出临界值（且要存放的位置非空）默认扩容方式为：扩容为原来容量的2倍
 *
 *    JDK8相较于JDK7底层实现方面的不同
 *    1. new HashMap()：底层没有直接创建一个长度为16的数组
 *    2. JDK8底层的数组：Node[]，而非Entry[]
 *    3. 首次调用put()方法时，底层创建长度为16的数组
 *    4. JDK7底层结构：数组+链表；JDK8底层结构：数组+链表+红黑树
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数>8，且当前数组长度>64时
 *      此时此索引位置上的所有数据改为使用红黑树存储
 *
 *      DEFAULT_INITIAL_CAPACITY：HashMapHashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子，0.75
 *      threshold：扩容的临界值 = 容量 * 加载因子，16 * 0.75 = 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转换为红黑树，8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量，64
 *
 * 四、LinkedHashMap底层实现原理
 *      LinkedHashMap中的内部类：Entry
 *      static class Entry<K,V> extends HashMap,Node<K,V>{
 *          Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *          Entry(int hash, K key, V value, Node<K,V> next){
 *              super(hash, key, value, next);
 *          }
 *      }
 *
 * 五、Map接口中的常用方法
 *   添加、删除、修改操作：
 *  Object put(Object key,value)：将指定key-value添加到 (或修改)当前map对象中
 *  void putAll(Map m)：将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *  总结：
 *  添加：put(Object key,value)
 *  删除：remove(Object key)
 *  修改：put(Object key,value)
 *  查询：get(Object key)
 *  长度：size()
 *  遍历：keySet() / values() / entrySet()
 *
 *
 * @author TuHong
 * @create 2021-02-01 12:00
 */
public class MapTest {

    /*
    元视图操作的方法
    Set keySet()：返回所有key构成的Set集合
    Collection values()：返回所有value构成的Collection集合
    Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println();
        //遍历所有的key-value：entrySet()
        //方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        System.out.println();
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "===>" + value);
        }


    }

    /*
    元素查询的操作：
    Object get(Object key)：获取指定key对应的value
    boolean containsKey(Object key)：是否包含指定的key
    boolean containsValue(Object value)：是否包含指定的value
    int size()：返回map中key-value对的个数
    boolean isEmpty()：判断当前map是否为空
    boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);

        //get(Object key)
        System.out.println(map.get(45));

        //containsKey(Object key)
        boolean isExist = map.containsKey("AA");
        System.out.println(isExist);

        //containsValue(Object value)
        isExist = map.containsValue(123);
        System.out.println(isExist);

        //isEmpty()
        map.clear();
        System.out.println(map.isEmpty());

        //equals(Object obj)
    }

    /*
    添加、删除、修改操作：
    Object put(Object key,value)：将指定key-value添加到 (或修改)当前map对象中
    void putAll(Map m)：将m中的所有key-value对存放到当前map中
    Object remove(Object key)：移除指定key的key-value对，并返回value
    void clear()：清空当前map中的所有数据
     */
    @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);
        //修改
        map.put("AA",456);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        Object cc = map.remove("CC");
        System.out.println(cc);//"cc"对应的value
        System.out.println(map);

        //clear()
        map.clear();//并非map = null;
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void test2(){
        HashMap map = new HashMap();
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(456,"BB");
        map.put(789,"CC");

        System.out.println(map);
    }

    @Test
    public void test1(){
        Map map = new HashMap();

        map.put(null,null);
        map.put(null,123);

    }
}
