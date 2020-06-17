package com.design.d03工厂方法模式.factory_method;

/**
 * 简单工厂的可扩展性不高
 *
 * 每次新增一个种类就要修改 如新增 龙 / 马
 */
public class M3 {
    public static void main(String[] args) {
        Aggressive3 a = new AttackFactory().createCat();
        a.attck();
    }
}


class AttackFactory {
    public Cat3 createCat(){
        return new Cat3();
    }

    public Dog3 createDog(){
        return new Dog3();
    }
}


interface Aggressive3 {
    public void attck();
}

class Cat3 implements  Aggressive3{
    @Override
    public void attck(){
        System.out.println("猫爪～～～");
    }
}

class Dog3 implements  Aggressive3{
    @Override
    public void attck(){
        System.out.println("狗咬～～～");
    }
}


