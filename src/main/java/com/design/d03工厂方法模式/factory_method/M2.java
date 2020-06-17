package com.design.d03工厂方法模式.factory_method;

public class M2 {
    public static void main(String[] args) {
        // 可以把你要选择的 攻击类定义在 xml里 这样就可以不改代码 根据配置初始化对象
        Aggressive a = new Cat2();
        a.attck();
    }
}

interface Aggressive {
    public void attck();
}

class Cat2 implements  Aggressive{
    @Override
    public void attck(){
        System.out.println("猫爪～～～");
    }
}

class Dog2 implements  Aggressive{
    @Override
    public void attck(){
        System.out.println("狗咬～～～");
    }
}

