package com.design.d01单例模式;

/**
 第一种写法：
 1。构造器为  private 修饰 出了这个类 无法被 new出来，别人想用只能调用 getInstance()
 2。getInstance() 返回的是 静态的 final 修饰的变量
 final 修饰的变量必须在赋值时被初始化，或者在 静态语句快里初始化

 使用场景：在你工作里，想用单例的时候，想不出来其他写法就用这个，这个非常简单。

 过程： 类加载到内存之后，就实例化一个单例， JVM保证线程安全
        JVM保证每一个 class 只会被 load 到内存一次, static 的变量是在 class load内存之后马上就进行初始化的
        所以它也保证就初始化一次

 简单使用：推荐这个
 缺点：
    "吹毛求疵" 不管你用到没用到， 类一加载的时候 实例就被初始化了
    "饿汉加载"
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){ return INSTANCE; }

    public static void main(String[] args) {
        Singleton01 s1 = getInstance();
        Singleton01 s2 = getInstance();
        System.out.println( s1 == s2);
    }
}
