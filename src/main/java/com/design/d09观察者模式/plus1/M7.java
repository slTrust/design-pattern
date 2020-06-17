package com.design.d09观察者模式.plus1;

import java.util.ArrayList;
import java.util.List;
/**
 * 根据 醒来的情况做不同的处理
 *
 * 给 WakeEvent 添加一个 触发源信息的内容
 */
public class M7 {
    public static void main(String[] args) {
        Child2 Child2 = new Child2();
        // 当 小孩醒了 这个事件 发生时，就会触发 所有的 观察者
        // 事件应该携带相关的信息
        // 什么时候醒了
        // 在那个位置醒了
        Child2.wakeUp();
    }
}

/**
 * 事件类
 * fireEvent
 */
class WakeUpEvent2 {
    long timestamp; // 时间
    String loc; // 位置
    Child2 source;

    public WakeUpEvent2(long timestamp, String loc, Child2 source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}

interface Observer2 {
    void actionOnWakeUp(WakeUpEvent2 event);
}

class Dad2 implements Observer2 {
    public void feed(){
        System.out.println("Dad2 feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent2 event) {
        feed();
    }
}

class Mom2 implements Observer2 {
    public void bao(){
        System.out.println("妈妈抱抱...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent2 event) {
        bao();
    }
}

class Dog2 implements Observer2 {
    public void wang(){
        System.out.println("汪汪...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent2 event) {
        wang();
    }
}

class Child2 {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private List<Observer2> Observer2s = new ArrayList<>();
    {
        Observer2s.add(new Dad2());
        Observer2s.add(new Mom2());
        Observer2s.add(new Dog2());
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

        WakeUpEvent2 event = new WakeUpEvent2(System.currentTimeMillis(),"bed",this);

        for (Observer2 o: Observer2s) {
            o.actionOnWakeUp(event);
        }
    }
}



