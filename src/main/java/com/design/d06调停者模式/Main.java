package com.design.d06调停者模式;

public class Main {
    public static void main(String[] args) {
        // 任何操作都跟中间人反馈，而不是 彼此直接相互作用
        中间人 z = new 中间人();
        亚瑟 ys = new 亚瑟(z, 500,100);
        韩信 hx = new 韩信(z, 300,150);

        solo(ys,hx);
    }

    public static void solo(Hero a, Hero b){
        while(a.getHp()>0 || b.getHp() >0){
            a.attack(b);
            b.attack(a);

            if(a.getHp()>0 && b.getHp()<=0){
                System.out.println(Hero.getHeroName(a) + "赢了");
                break;
            }
            if(b.getHp()>0 && a.getHp()<=0){
                System.out.println(Hero.getHeroName(b) + "赢了");
                break;
            }
        }
    }


}


interface Mediator {
    /**
     * 同事对象在自身改变的时候来通知调停者方法
     * 让调停者去负责相应的与其他同事对象的交互
     */
    public void change(Hero f, Hero t);
}

class 中间人 implements Mediator {
    @Override
    public void change(Hero f, Hero t) {
        // f 是攻击者
        // t 是被攻击者
        // 重新设置血量

        int attackValue = f.getAttack_value();
        int hp = t.getHp();
        int tempHp = hp - attackValue;

        if(tempHp<=0){
            tempHp = 0;
        }
        t.setHp(tempHp);
        System.out.println(Hero.getHeroName(f) + "打掉了 " + Hero.getHeroName(t) + " 剩余血量为："+ t.getHp());
    }
}

abstract class Hero {
    //持有一个调停者对象
    private Mediator mediator;

    private int hp;
    private int attack_value;

    /**
     * 构造函数
     */
    public Hero(Mediator mediator, int hp,int attack_value) {
        this.mediator = mediator;
        this.hp = hp;
        this.attack_value = attack_value;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack_value() {
        return attack_value;
    }

    public void setAttack_value(int attack_value) {
        this.attack_value = attack_value;
    }

    public void attack(Hero target) {
        System.out.println(Hero.getHeroName(this) + " attack了 " + Hero.getHeroName(target));
        this.getMediator().change(this, target);
    }

    public static String getHeroName(Hero o){
        String full_name = o.getClass().getName();
        String pkg_name = o.getClass().getPackage().getName();
        return full_name.replace(pkg_name+".","");
    }
}

class 亚瑟 extends Hero {
    public 亚瑟(Mediator mediator, int hp,int attack_value) {
        super(mediator, hp,attack_value);
    }
}

class 韩信 extends Hero {
    public 韩信(Mediator mediator, int hp,int attack_value) {
        super(mediator, hp,attack_value);
    }
}
