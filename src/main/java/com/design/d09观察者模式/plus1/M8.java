package com.design.d09观察者模式.plus1;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据 醒来的情况做不同的处理
 *
 * 给 WakeEvent 添加一个 触发源信息的内容
 *
 * + 使用  Event 来约定范型参数
 * + ObserverListener 可以是 lambda 表达式  / hook / callback
 *
 */
public class M8 {
    public static void main(String[] args) {
        Child3 Child3 = new Child3();
        // 当 小孩醒了 这个事件 发生时，就会触发 所有的 观察者
        // 事件应该携带相关的信息
        // 什么时候醒了
        // 在那个位置醒了
        Child3.wakeUp();
    }
}

abstract class Event<T> {
    abstract T getSource();
}

/**
 * 事件类
 * fireEvent
 */
class WakeUpEvent3 extends Event<Child3> {
    long timestamp; // 时间
    String loc; // 位置
    Child3 source;

    public WakeUpEvent3(long timestamp, String loc, Child3 source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    public Child3 getSource() {
        return source;
    }
}

interface Observer3 {
    void actionOnWakeUp(WakeUpEvent3 event);
}

class Dad3 implements Observer3 {
    public void feed(){
        System.out.println("Dad3 feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent3 event) {
        feed();
    }
}

class Mom3 implements Observer3 {
    public void bao(){
        System.out.println("妈妈抱抱...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent3 event) {
        bao();
    }
}

class Dog3 implements Observer3 {
    public void wang(){
        System.out.println("汪汪...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent3 event) {
        wang();
    }
}

class Child3 {
    private boolean cry = false;
    // 把观察者 加载 被观察者 内部
    private List<Observer3> observer3s = new ArrayList<>();
    {
        observer3s.add(new Dad3());
        observer3s.add(new Mom3());
        observer3s.add(new Dog3());
        observer3s.add((e)->{
            System.out.println("ppp");
        });
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

        WakeUpEvent3 event = new WakeUpEvent3(System.currentTimeMillis(),"bed",this);

        for (Observer3 o: observer3s) {
            o.actionOnWakeUp(event);
        }
    }
}

