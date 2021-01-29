package com.th1024.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author TuHong
 * @create 2021-01-29 14:03
 */

@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
