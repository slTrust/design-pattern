package com.design.d12代理模式.v5;

import java.util.Random;

/**
 * 多个代理的组合实现
 * - 代理构造器里的 Tank 改为 Movable
 * - 这样就能实现 不同代理的各种需求
 * <p>
 * <p>
 * 最简单的最基础的静态代理代码实现！！！
 * 最简单的最基础的静态代理代码实现！！！
 * 最简单的最基础的静态代理代码实现！！！
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
        // 先日志在时间
        new TankTimeProxy(
                new TankLogProxy(
                        new Tank()
                )
        ).move();
    }
}

class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("tank start moving~");
        m.move();
        System.out.println("tank end moving~");
    }
}

interface Movable {
    void move();
}

