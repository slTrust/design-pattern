package com.design.d18命令模式;

public abstract class Command {
    // 运行命令
    public abstract void doit(); //exec run
    // 撤回
    public abstract void undo();
}
