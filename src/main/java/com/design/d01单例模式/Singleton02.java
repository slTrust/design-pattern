package com.design.d01单例模式;

/**
 * 没啥说的：跟 上一个的区别就是在 static 语句块里初始化
 */
public class Singleton02 {
    private static final Singleton02 INSTANCE;
    static {
        INSTANCE = new Singleton02();
    }
    private Singleton02(){}

    public static Singleton02 getInstance(){ return INSTANCE; }

    public static void main(String[] args) {
        Singleton02 s1 = getInstance();
        Singleton02 s2 = getInstance();
        System.out.println( s1 == s2);
    }
}
