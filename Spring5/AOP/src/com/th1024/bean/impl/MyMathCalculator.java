package com.th1024.bean.impl;

import com.th1024.bean.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author TuHong
 * @create 2021-04-16 14:07
 */

@Service
public class MyMathCalculator /*implements Calculator*/ {
//    @Override
    public int add(int i, int j) {
        return i + j;
    }

//    @Override
    public int sub(int i, int j) {
        return i - j;
    }

//    @Override
    public int mul(int i, int j) {
        return i * j;
    }

//    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
