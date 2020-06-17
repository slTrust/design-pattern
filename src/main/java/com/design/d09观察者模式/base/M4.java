package com.design.d09观察者模式.base;

/**
 * 被观察者 内部 加入一群观察者 Dad/Mom/Dog
 *
 * 缺陷：
 *      每当加入新的观察者的时候都要 修改 Child03内部
 *      而且它还不灵活
 *          观察者存在其他的处理方式，不想和 Child03 耦合在一起
 *          比如 狗 不一定看见孩子醒了 就开始叫 ，也有可能看到床底下跑出来一只老鼠，如果限定在 Child03内部 就被限定了
 *
 */
public class M4 {
    public static void main(String[] args) {
        Child03 Child03 = new Child03();
        Child03.wakeUp();
    }
}

class Dad2 {
    public void feed(){
        System.out.println("dad feeding...");
    }
}

class Mom {
    public void bao(){
        System.out.println("妈妈抱抱...");
    }
}

class Dog {
    public void wang(){
        System.out.println("汪汪...");
    }
}

class Child03 {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private Dad2 d = new Dad2();
    private Mom m = new Mom();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void setCry(boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
        m.bao();
        dog.wang();
    }
}
