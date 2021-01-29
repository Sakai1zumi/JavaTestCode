package com.th1024.Annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用
 *
 * 1. 理解Annotation：
 *
 * ① JDK5.0新增的功能
 *
 * ② Annotation是代码中的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理
 *  通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 *
 *  ③ 在JavaSE中，注解的使用目比较简单，例如标记过时功能，忽略警告等。
 *   在JavaEE/Android中注解占据了更重要的角色，例如用来配置应程序的任何切面，代替JavaEE繁冗代码和XML配置等
 *
 *  2. Annotation的使用示例
 *
 *  示例一：生成文档相关的注解
 *
 *  示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *  @Override: 限定重写父类方法 , 该注解只能用于方法
 *  @Deprecated :用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好选择
 *  @SuppressWarnings : 抑制编译器警告
 *
 *  示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 *  3. 如何自定义注解：参照@SuppressWarnings定义
 *      >使用@interface关键字定义
 *      >内部定义成员，通常用value表示
 *      >可以指定成员的默认值，使用default定义
 *      >如果自定义注解没有成员，表明是一个标识作用
 *    >如果注解有成员，在使用注解时，需指定成员的值
 *    >自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 *    >自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4. JDK提供的四种元注解
 *      元注解：对现有的注解进行解释说明的注解
 *      Retention：指定所修饰的Annotation的生命周期：SOURCE、CLASS、RUNTIME
 *      Target：指定所修饰的Annotation能修饰哪些结构
 *      Documented：指明所修饰的Annotation在执行javadoc命令之后能保留下来
 *      Inherited：指明所修饰的Annotation具有继承性
 *
 * 5. 通过反射获取注解信息
 *
 * 6. JDK8中注解的新特性：可重复注解、类型注解
 *
 *      可重复注解：
 *      ① 在MyAnnotation上声明@Repeatable，程远志为MyAnnotations.class
 *      ② MyAnnotation的@Target和@Retention等元注解和MyAnnotations相同
 *
 *      类型注解：
 *      ① ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *      ② ElementType.TYPE_USE表示该注解能写在使用类型的任何语句中 。
 *
 * @author TuHong
 * @create 2021-01-29 12:18
 */
public class AnnotationTest {

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println(num);

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();
    }
    @Test
    public void test1(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}


@MyAnnotation("hi")
@MyAnnotation("acb")
class Person{

}

class Student extends Person{

}
