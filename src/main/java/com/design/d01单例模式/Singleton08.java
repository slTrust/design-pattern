package com.design.d01单例模式;

import java.util.HashMap;
import java.util.Map;


/**
 * 单例模式:  java创始人之一 他写的一本书 effective java 里 他写了一个单例方法
 * 使用 enum
 *
 *
 * 枚举单例： 完美中的完美 ，不仅可以解决线程同步，还能防止反序列化
 *
 *
 * 序列化问题？ 为什么做单例的时候要阻止这一点
 * java的反射可以通过 加载class文件 然后 newInstance 方式创建实例
 *
 * 枚举单例不会被序列化的原因是：枚举类没有构造方法,就算你拿到他的class 也没法构造它的对象
 *
 * 但是这个写法非常的别扭
 * 为什么枚举没有构造方法？java语言规定 你反编译之后 枚举是一个 abstract class
 *
 */
public enum Singleton08 {

    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                // 不同对象 hash码是不同的
                int hashCode = Singleton08.INSTANCE.hashCode();
                map.put(hashCode,"");
            }).start();
        }
        System.out.println(map);

        Singleton08.INSTANCE.doSomething();
    }
}

