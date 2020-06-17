package com.design.d12代理模式.v4;

import java.util.Random;

/**
 * 聚合方式：实现记录坦克运行时间
 *
 * 各种各样的需求，日志，统计运行时间
 *
 * 如何实现多个 代理的组合
 * 先日志在统计运行时间， 先运行时间在日志？
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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}


class TankLogProxy implements Movable {
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("tank start moving~");
        tank.move();
        System.out.println("tank end moving~");
    }
}

interface Movable {
    void move();
}

