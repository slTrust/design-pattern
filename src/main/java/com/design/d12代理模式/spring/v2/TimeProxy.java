package com.design.d12代理模式.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {
    // 注解方式 aop  com.design.d12代理模式.spring.v2.Tank.*() 代表 Tank的所有方法
    @Before("execution (void com.design.d12代理模式.spring.v2.Tank.move())")
    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    @After("execution (void com.design.d12代理模式.spring.v2.Tank.move())")
    public void after() {
        System.out.println("method stop.." + System.currentTimeMillis());
    }

}
