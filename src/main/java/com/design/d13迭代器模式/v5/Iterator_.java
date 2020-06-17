package com.design.d13迭代器模式.v5;

/**
 * 为了遍历，所有容器都去实现这个接口
 */
public interface Iterator_ {
    boolean hasNext();

    Object next();
}
