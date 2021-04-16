package com.th1024.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author TuHong
 * @create 2021-04-09 15:12
 */

@Configuration
@ComponentScan(basePackages = {"com.th1024"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig {
}
