package com.design.d12代理模式.v1;


import java.util.Random;

/**
 * 需求：如何记录 Tank 开了多长时间
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
}

interface Movable {
    void move();
}
