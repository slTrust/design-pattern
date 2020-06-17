package com.design.d09观察者模式.base;

/**
 * 把观察者 Dad 加到 被观察者 内部
 *
 * 当 child 醒了 通知观察者
 *
 * 这样就非常耦合
 */
public class M3 {
    public static void main(String[] args) {
        Child02 child02 = new Child02();
        child02.wakeUp();
    }
}

class Dad {
    public void feed(){
        System.out.println("dad feeding...");
    }
}

class Child02 {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void setCry(boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
    }
}

