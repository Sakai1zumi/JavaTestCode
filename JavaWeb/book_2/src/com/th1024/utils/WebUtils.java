package com.th1024.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author TuHong
 * @create 2021-03-26 16:40
 */
public class WebUtils {

    /**
     * 将Map中的数据注入到对应的JavaBean对象中
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map map,T bean){

        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * 将字符串转换为int类型的变量
     * @param str
     * @param defaultValue
     * @return
     */
    public static int getValue(String str,int defaultValue){
        int value = defaultValue;

        try {
            value =  Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
}
