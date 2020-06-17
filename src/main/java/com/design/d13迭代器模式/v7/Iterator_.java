package com.design.d13迭代器模式.v7;

public interface Iterator_<E> { //Element //Type //K //Value V Tank
    boolean hasNext();

    E next(); //Tank next() Iterator_<Tank> it = ... Tank t = it.next();
}
