package com.design.d18命令模式;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "java是最好的编程语言";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
    }
}
