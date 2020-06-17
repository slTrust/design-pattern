package com.design.d03工厂方法模式.factory_method;

/**
 * 需求灵活指定 选择谁进行攻击
 */
public class M1 {
    public static void main(String[] args) {
        // 我用 Cat就要这样
        Cat1 c = new Cat1();
        c.attck();

        // 我要 Dog 就要把 Cat注释了
        Dog1 d = new Dog1();
        d.attck();

        // 下次用 Man 继续改代码
    }
}

class Cat1 {
    public void attck(){
        System.out.println("猫爪～～～");
    }
}

class Dog1 {
    public void attck(){
        System.out.println("狗咬～～～");
    }
}

class Man1 {
    public void attck(){
        System.out.println("乎你熊脸～～～");
    }
}