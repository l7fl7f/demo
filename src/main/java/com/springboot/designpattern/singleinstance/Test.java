package com.springboot.designpattern.singleinstance;

public class Test {
    public static void main(String[] args) {
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
        Singleton4.INSTANCE.method();
    }
}
