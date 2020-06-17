package com.design.d12代理模式.v2;

import java.util.Random;

/**
 * 需求：如何记录 Tank 开了多长时间
 * move 方法内首尾记录时间节点
 *
 * 缺点：在代码内部修改
 *
 * 总结：
 *      brenchmark 方法性能测试
 *      慎用继承
 */
public class Tank implements Movable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank moving ....");
        try {
            // 模拟开了 xx秒
            int mtime = new Random().nextInt(10000);
            Thread.sleep(mtime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
    }
}

interface Movable {
    void move();
}

