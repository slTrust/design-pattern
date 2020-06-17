package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;


/**
 * 单例模式
 * 静态内部类写法： 最完美的
 *
 * 优于 Singleton01 写法
 *
 * 解释：
 *      加载 Singleton07 的时候，里面的 SingletonHolder 是不会被加载的
 *      什么时候加载呢？ 当然是你调用 getInstance()的时候 此时静态内部类才会被加载
 *
 *      他是如何保证线程安全的？
 *          JVM保证的，虚拟机加载一个class的时候只加载一次，所以 SingletonHolder 只加载一次
 *
 */
public class Singleton07 {
    private static Singleton07 INSTANCE;

    // 定义静态内部类
    private static class SingletonHolder {
        private final static Singleton07 INSTANCE = new Singleton07();
    }

    private Singleton07(){}

    public static Singleton07 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton07.getInstance().hashCode();
                map.put(hashCode,"");
            }).start();
        }

        System.out.println(map);
    }
}

