package com.design.d09观察者模式.base;

/**
 * 面向对象的傻等，跟M1 没有任何本质区别， 只不过M1 是面向过程的方式
 */
public class M2 {
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        while (!child.isCry()) {
            Thread.sleep(1000);
            System.out.println("observing...");
        }
    }
}

class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void setCry(boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        System.out.println("waked up ! crying wu wu wu ~ ~ ~");
        cry = true;
    }
}
