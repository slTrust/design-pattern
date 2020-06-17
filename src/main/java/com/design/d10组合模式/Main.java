package com.design.d10组合模式;

import java.util.ArrayList;
import java.util.List;

abstract class Node {
    abstract public void p();
}

// 叶子节点
class LeafNode extends Node{
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

// 可有有孩子的节点
class BranchNode extends Node{
    String name;
    List<Node> nodes = new ArrayList<>();

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }
    public void add(Node node){
        nodes.add(node);
    }
}


public class Main{
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode c1 = new BranchNode("c1");
        BranchNode c2 = new BranchNode("c2");
        LeafNode n1 = new LeafNode("1.txt");
        LeafNode n2 = new LeafNode("2.txt");

        BranchNode s1 = new BranchNode("s1");
        LeafNode s3 = new LeafNode("s3.txt");
        LeafNode s4 = new LeafNode("s4.txt");

        root.add(c1);
        root.add(c2);
        c1.add(n1);
        c1.add(n2);

        c2.add(s1);
        s1.add(s3);
        s1.add(s4);

        tree(root,0);
    }

    public static void tree(Node b,int lv){
        for (int i = 0; i < lv; i++) {
            System.out.print("--");
        }
        b.p();
        if(b instanceof BranchNode){
            for (Node n: ((BranchNode) b).nodes) {
                tree(n,lv + 1);
            }
        }
    }
}
