package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;

/**
 * "懒汉式"
 * "懒加载"
 *
 * 缺点：
 *      多线程访问的时候，带来了不安全性
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    private Singleton03(){}

    public static Singleton03 getInstance(){
        if(INSTANCE == null){
            try {
                // 这个延时不是必要的 ，只是因为 语句和线程执行速度太快了 ，因为 if(INSTANCE == null) 这句话会存在多个线程满足条件进入
                // 中间加了1毫秒增加了其他线程打断的可能性，所以你更容易看到代码的问题，不加延时你会看到map里只有一个key。
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton03.getInstance().hashCode();
                map.put(hashCode,"");
            }).start();
        }

        System.out.println(map);
    }
}
