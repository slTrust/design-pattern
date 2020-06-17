package com.design.d12代理模式.v6;

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
        m2();
    }

    // 匿名内部类实现代理
    public static void m1(){
        Tank tank = new Tank();
        // 反射 ： 通过二进制字节码 分析类的属性和方法
        Movable movable = (Movable) Proxy.newProxyInstance( // 创建代理对象
                Tank.class.getClassLoader(), // classLoader 你需要那个loader把你 new出来的代理对象 load内存
                new Class[]{Movable.class}, // 代理对象应该实现那些接口
                new InvocationHandler() { // 调用时候的处理器
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method:"+ method.getName() + " start~");
                        Object o = method.invoke(tank,args);
                        System.out.println("method:"+ method.getName() + " end~");
                        return 0;
                    }
                }
        );
        movable.move();
    }

    public static void m2(){
        Tank tank = new Tank();
        // 反射 ： 通过二进制字节码 分析类的属性和方法
        Movable movable = (Movable) Proxy.newProxyInstance( // 创建代理对象
                Tank.class.getClassLoader(), // classLoader 你需要那个loader把你 new出来的代理对象 load内存
                new Class[]{Movable.class}, // 代理对象应该实现那些接口
                // 调用时候的处理器
                new LogHandler(tank)
        );
        movable.move();
    }
}

class LogHandler implements InvocationHandler{
    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy 参数 不是被代理对象，而是生成 代理对象 就是 LogHandler

        System.out.println("method:"+ method.getName() + " start~");
        Object o = method.invoke(tank,args); // 这里的方法就是 传递的 被代理对象
        System.out.println("method:"+ method.getName() + " end~");
        return o;
    }
}

interface Movable {
    void move();
}

