package com.design.d12代理模式.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 问题：我想记录坦克运行时间
 * 最简单方法，在 Tank 内部 move 上修改代码记录时间
 * 问题2： 如何不修改 Tank 的 move方法呢？
 * 用继承？ 慎用～～～
 * 使用代理 v3
 * 问题3： 我有多个代理如何咋办？
 *  Decorator?
 * 问题4 ：如何满足复杂的需求  先日志后时间，先时间后日志？
 *  代理的对象改成 Movable  v5,越来越 Decorator了
 *
 *  问题5： 如果此时 坦克有了 stop方法，我也想代理怎么办？
 *  修改 Proxy类里的 Movable 为 Object
 *  分离代理行为和被代理对象
 *  使用 jdk 动态代理
 *
 *  jdk反射生成代理必须面向接口，这是由 Proxy 内部实现决定的 newProxyInstance 第二个参数指定了你必须传递接口
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank moving ....");
        try {
            // 模拟开了 xx秒
            long mtime = new Random().nextInt(10000);
            Thread.sleep(mtime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        m1();
    }

    public static void m1(){
        Tank tank = new Tank();

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        // 获取动态代理生成的类的代码  com.design.d12代理模式.v7.$Proxy0.class
        // 源码非常值得一看
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 反射 ： 通过二进制字节码 分析类的属性和方法
        Movable movable = (Movable) Proxy.newProxyInstance( // 创建代理对象
                Tank.class.getClassLoader(), // classLoader 你需要那个loader把你 new出来的代理对象 load内存
                new Class[]{Movable.class}, // 代理对象应该实现那些接口
                // 调用时候的处理器
                new TimeHandler(tank)
        );
        movable.move();
    }
}

class TimeHandler implements InvocationHandler {
    Movable m;

    public TimeHandler(Movable m) {
        this.m = m;
    }

    public void before(Method method){
        System.out.println("method:"+ method.getName() + " start~");
    }

    public void after(Method method){
        System.out.println("method:"+ method.getName() + " end~");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method);
        Object o = method.invoke(m,args);
        after(method);
        return o;
    }
}

interface Movable {
    void move();
}
