package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;


/**
 * "懒汉式" 升级版 修复 线程不安全问题
 *
 * 添加了 synchronized 语句块
 *
 * 缺点：加锁效率会下降
 *        因为每次 getInstance 都会去申请这把锁，然后才能进行操作，效率就降低了
 *
 *        下一种写法： 加锁的同时还把效率提供
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

    private Singleton04(){}

    public static synchronized Singleton04 getInstance(){
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton04.getInstance().hashCode();
                map.put(hashCode,"");
            }).start();
        }

        System.out.println(map);
    }
}

