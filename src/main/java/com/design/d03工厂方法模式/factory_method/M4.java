package com.design.d03工厂方法模式.factory_method;

public class M4 {
    public static void main(String[] args) {
        // Aggressive4 a = new Cat4Factory().create();
        Aggressive4 a = new Dog4Factory().create();
        a.attck();
    }
}

class Cat4Factory {
    public Cat4 create(){
        return new Cat4();
    }
}

class Dog4Factory {
    public Dog4 create(){
        return new Dog4();
    }
}

interface Aggressive4 {
    public void attck();
}

class Cat4 implements  Aggressive4{
    @Override
    public void attck(){
        System.out.println("猫爪～～～");
    }
}

class Dog4 implements  Aggressive4{
    @Override
    public void attck(){
        System.out.println("狗咬～～～");
    }
}



