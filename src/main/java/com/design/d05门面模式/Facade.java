package com.design.d05门面模式;

/**
 * 门面模式
 *
 * 客户是 张三
 * 包工头是 门面 由他来协调具体细节
 */
public class Facade {
    public static void main(String[] args) {
        Client z3 = new Client();
        z3.makeHouse();
    }
}

// 张三：北漂多年回家的码农要盖楼
class Client {
    public void makeHouse(){
        System.out.println("客户 张三跟 包工头说 我要盖 xxx样的房子");
        包工头 facade=new 包工头();
        facade.build();
    }
}

class 包工头 {
    public void build(){
        System.out.println("包工头开始 为张三盖房子 开始给工人分配任务");
        PeopleBanZhuan 搬砖工 = new PeopleBanZhuan();
        搬砖工.banzhuan();
        PeopleHuoNi 和泥工 = new PeopleHuoNi();
        和泥工.huoni();
        PeopleQiqiang 砌墙工 = new PeopleQiqiang();
        砌墙工.qiqiang();
    }
}

class PeopleBanZhuan {
    public void banzhuan() { System.out.println("我开始搬砖了。。。。。。"); }
}

class PeopleHuoNi {
    public void huoni() { System.out.println("我开始和泥了。。。。。。"); }
}

class PeopleQiqiang {
    public void qiqiang() { System.out.println("我开始砌墙了。。。。。。"); }
}