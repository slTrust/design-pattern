package com.design.d09观察者模式.base;

import java.util.ArrayList;
import java.util.List;

public class M5 {
    public static void main(String[] args) {
        Child5 child5 = new Child5();
        // 当 小孩醒了 这个事件 发生时，就会触发 所有的 观察者
        child5.wakeUp();
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad5 implements Observer {
    public void feed(){
        System.out.println("dad feeding...");
    }

    public void actionOnWakeUp() {
        feed();
    }
}

class Mom5 implements Observer {
    public void bao(){
        System.out.println("妈妈抱抱...");
    }

    @Override
    public void actionOnWakeUp() {
        bao();
    }
}

class Dog5 implements Observer{
    public void wang(){
        System.out.println("汪汪...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}

class Child5 {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad5());
        observers.add(new Mom5());
        observers.add(new Dog5());
    }

    public boolean isCry() {
        return cry;
    }

    public void setCry(boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        cry = true;
        for (Observer o: observers) {
            o.actionOnWakeUp();
        }
    }
}
