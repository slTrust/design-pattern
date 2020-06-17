package com.design.d02策略模式;

public class Strategy01 {

    private Settlement settlement;

    public Strategy01() {
    }

    public Strategy01(Settlement settlement) {
        this.settlement = settlement;
    }

    public void 某东支付lowB版(String type, double totalPrice) {
        double res = 0;
        switch (type) {
            case "铜牌会员":
                res = totalPrice * 0.9;
                break;
            case "金牌会员":
                res = totalPrice * 1.1;
                break;
            default:
                res = totalPrice;
        }
        System.out.println("某东lowB版支付:会员种类："+ type+ "，总计：" + res);
    }

    public void 某东付费(double totalPrice) {
        System.out.println("某东策略模式版支付：会员种类：" + settlement.getClass().getName() + "，总计"+settlement.charge(totalPrice));
    }

    public static void main(String[] args) {
        /*
        lowB版 每次都要改 switch 里的 case
            逻辑写在代码内部，不方便扩展，同时不方便维护代码
         */
        Strategy01 s4 = new Strategy01();
        s4.某东支付lowB版("普通会员", 1000);
        s4.某东支付lowB版("铜牌会员", 1000);
        s4.某东支付lowB版("金牌会员", 1000);

        /*
        策略模式版 不需要改内部代码，只需要 自定义策略实现即可
         */
        Strategy01 s = new Strategy01(new 普通用户());
        s.某东付费(1000);

        Strategy01 s2 = new Strategy01(new 铜牌会员());
        s2.某东付费(1000);

        Strategy01 s3 = new Strategy01(new 金牌会员());
        s3.某东付费(1000);

    }
}

/**
 * 结算计费接口
 */
interface Settlement {
    // 付费接口
    public double charge(double price);
}

/*
无任何优惠
*/
class 普通用户 implements Settlement {
    @Override
    public double charge(double price) {
        return price;
    }
}

// 9折
class 铜牌会员 implements Settlement {
    @Override
    public double charge(double price) {
        return price * 0.9;
    }
}

// 杀熟 打折
class 金牌会员 implements Settlement {
    // 优惠券满减金额
    int plusDiscount = 80;

    @Override
    public double charge(double price) {
        double res = price * 1.2;
        if (res > 500) {
            // 超过500才有优惠券
            res = res - plusDiscount;
        }
        return res;
    }
}
