package com.design.d07装饰器模式;

public class Main {

    public static void main(String[] args) {
        //原味咖啡
        Coffee c = new SimpleCoffee();
        print(c);

        //增加牛奶的咖啡
        c = new WithMilk(c);
        print(c);

        //再加一点糖
        c = new WithSugar(c);
        print(c);
    }

    static void print(Coffee c) {
        System.out.println("花费了: " + c.getCost());
        System.out.println("配料: " + c.getIngredients());
        System.out.println("============");
    }
}

/**
 * 咖啡
 */
interface Coffee {
    /** 获取价格 */
    double getCost();
    /** 获取配料 */
    String getIngredients();
}

/**
 * 原味咖啡
 */
class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}

/**
 * 咖啡的"装饰器"，可以给咖啡添加各种"配料"
 */
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    /**
     * 在构造方法中，初始化咖啡对象的引用
     */
    public CoffeeDecorator(Coffee coffee) {
        decoratedCoffee = coffee;
    }

    /**
     * 装饰器父类中直接转发"请求"至引用对象
     */
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}

/**
 * 此装饰类混合"牛奶"到原味咖啡中
 */
class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        double additionalCost = 0.5;
        return super.getCost() + additionalCost;
    }

    @Override
    public String getIngredients() {
        String additionalIngredient = "milk";
        return super.getIngredients() + ", " + additionalIngredient;
    }
}

class WithSugar extends CoffeeDecorator {

    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", Sugar";
    }
}

