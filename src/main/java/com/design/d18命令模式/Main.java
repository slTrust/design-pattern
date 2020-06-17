package com.design.d18命令模式;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void doAndUndo(){
        Content c = new Content();
        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();

        Command deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undo();

    }
    public static void main(String[] args) {

        doAndUndo();

        // 一堆操作
        operations();
    }

    public static void operations(){
        Content c = new Content();

        List<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(c));
        commands.add(new CopyCommand(c));
        commands.add(new DeleteCommand(c));

        for(Command comm : commands) {
            comm.doit();
        }

        // 一系列操作后的结果
        System.out.println(c.msg);
        System.out.println("分割线");

        for(int i= commands.size()-1; i>=0; i--) {
            commands.get(i).undo();
        }

        // 回退后的初始状态
        System.out.println(c.msg);
    }
}


