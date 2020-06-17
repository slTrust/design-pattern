package com.design.d09观察者模式.plus1;


import java.util.ArrayList;
import java.util.List;

/**
 * 根据 醒来的情况做不同的处理
 */
public class M6 {
    public static void main(String[] args) {
        Child Child = new Child();
        // 当 小孩醒了 这个事件 发生时，就会触发 所有的 观察者
        // 事件应该携带相关的信息
        // 什么时候醒了
        // 在那个位置醒了
        Child.wakeUp();
    }
}

/**
 * 事件类
 * fireEvent
 */
class WakeUpEvent {
    long timestamp; // 时间
    String loc; // 位置

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {
    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mom implements Observer {
    public void bao(){
        System.out.println("妈妈抱抱...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        bao();
    }
}

class Dog implements Observer {
    public void wang(){
        System.out.println("汪汪...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}

class Child {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void setCry(boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        // 这个 醒来 可以更加具体
        // 半夜醒来，
        // 早上醒来
        // 在床上
        // 掉在地上
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"bed");

        for (Observer o: observers) {
            o.actionOnWakeUp(event);
        }
    }
}



