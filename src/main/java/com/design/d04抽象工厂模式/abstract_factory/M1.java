package com.design.d04抽象工厂模式.abstract_factory;

/**
 * 产品族
 */
public class M1 {
    public static void main(String[] args) {
//        AbstractWarFactory a = new 关羽();
        AbstractWarFactory a = new 现代战士();
        Food f = a.createFood();
        f.eat();
        Transport t = a.createTransport();
        t.go();
        Weapon w = a.createWeapon();
        w.attack();
    }
}

class 关羽 extends AbstractWarFactory {
    @Override
    Food createFood() {
        return new 大米();
    }

    @Override
    Transport createTransport() {
        return new 赤兔();
    }

    @Override
    Weapon createWeapon() {
        return new 青龙偃月刀();
    }
}


class 现代战士 extends AbstractWarFactory {
    @Override
    Food createFood() {
        return new 压缩饼干();
    }

    @Override
    Transport createTransport() {
        return new 坦克();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}

/**
 * 抽象工厂
 * 交通工具
 * 吃饭补充体力
 * 会攻击
 * <p>
 * 上古 / 现代的打仗
 */
abstract class AbstractWarFactory {
    abstract Food createFood();

    abstract Transport createTransport();

    abstract Weapon createWeapon();
}

abstract class Transport {
    abstract void go();
}

class 赤兔 extends Transport {
    @Override
    public void go() {
        System.out.println("马中赤兔～");
    }
}

class 坦克 extends Transport {
    @Override
    public void go() {
        System.out.println("履带滚动～");
    }
}

abstract class Food {
    abstract void eat();
}

class 大米 extends Food {
    @Override
    public void eat() {
        System.out.println("大米白饭～～～");
    }
}

class 压缩饼干 extends Food {
    @Override
    public void eat() {
        System.out.println("压缩饼干加白开水～～～");
    }
}

abstract class Weapon {
    abstract void attack();
}

class 青龙偃月刀 extends Weapon {
    @Override
    public void attack() {
        System.out.println("青龙偃月刀抡扫～～～");
    }
}

class AK47 extends Weapon {
    @Override
    public void attack() {
        System.out.println("AK扫射～～～");
    }
}

/**
 * 为什么 这里用的 Food / Weapon / Transport 是 abstract  class 而不是 interface
 * 而在 factory_method 里用的确是 interface
 *
 * 首先这是一个语义的问题
 * 因为 Food 对应现实世界里的真实存在的 但又不是具体的事物， 所以用抽象类
 * 而 Aggressive 代表可攻击的东西，代表某个行为 猫/狗/人 都具有攻击性
 *
 * 形容词用接口，名词用抽象类
 *
 */

