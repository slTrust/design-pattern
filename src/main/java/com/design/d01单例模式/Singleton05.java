package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;


/**
 * "懒汉式" 升级版 修复 线程不安全问题
 *
 * 解决 synchronized 加锁效率慢问题 **实际没解决**
 *
 *
 * 缺点：
 *      虽然不再 getInstance 上加 synchronized 了，
 *      但是在 这句话 会存在多个线程满足条件进去 if语句块 等待锁释放后 导致破坏单例
 *       if(INSTANCE == null){
 *
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;

    private Singleton05(){}

    public static Singleton05 getInstance(){
        if(INSTANCE == null){ // 问题就在这一行 ：此时可能多个线程都满足条件，进入 if内 所以仍然不是单例

            synchronized(Singleton05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton05.getInstance().hashCode();
                map.put(hashCode,"");
            }).start();
        }

        System.out.println(map);
    }
}

