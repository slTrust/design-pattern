package com.design.d11享元模式;

public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println( s1 == s2 ); // true 因为所有字符串都放在常量池里
        System.out.println( s1 == s3 ); // false s1 直接指向常量池，s3是在堆里new了一个对象

        System.out.println( s3 == s4 ); // false 堆里两个不同地址的对象
        System.out.println( s3.intern() == s1); // true  s3.intern() 指的是它内部指向常量池的对象
        System.out.println( s3.intern() == s4.intern()); // true

    }
}
