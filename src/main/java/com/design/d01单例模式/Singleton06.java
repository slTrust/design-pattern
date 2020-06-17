package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;


/**
 * "懒汉式" 最完美的单例写法
 *  处女座专用写法
 *  双判断 ：双重检查，单例写法
 *
 *  雷人语句： 受精卵的两次屏蔽作用！！！
 */
public class Singleton06 {
     private static Singleton06 INSTANCE;
    /*
    java汇编语句优化 JIT优化会把java代码变为本地代码，此时会发生指令重排
    如果不加 volatile 不然有可能直接返回 未初始化的 INSTANCE
    */
    // private static volatile Singleton06 INSTANCE;

    private Singleton06(){}

    public static Singleton06 getInstance(){
        if(INSTANCE == null){ // 问题就在这一行 ：此时可能多个线程都满足条件，进入 if内 所以仍然不是单例
            // 双重检查
            synchronized(Singleton06.class){
                // 上锁之后再次判断是不是 null
                if(INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton06.getInstance().hashCode();
                map.put(hashCode,"");
            }).start();
        }

        System.out.println(map);
    }
}

