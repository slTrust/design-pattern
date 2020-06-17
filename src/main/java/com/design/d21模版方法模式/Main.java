package com.design.d21模版方法模式;

public class Main {
    public static void main(String[] args) {
        大厨 c = new 大厨();
        c.做饭();
    }

}

abstract class 厨艺 {
    // 模版：做饭的流程
    public void 做饭() {
        刷锅();
        炒菜();
    }

    abstract void 刷锅();
    abstract void 炒菜();
}

class 大厨 extends 厨艺 {

    @Override
    void 刷锅() {
        System.out.println("op1");
    }

    @Override
    void 炒菜() {
        System.out.println("op2");
    }
}
