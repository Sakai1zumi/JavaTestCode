package com.th1024.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author TuHong
 * @create 2021-04-08 21:13
 */

@Configuration //作为配置类，代替xml文件
@ComponentScan(value = "com.th1024")
public class SpringConfig {
}
