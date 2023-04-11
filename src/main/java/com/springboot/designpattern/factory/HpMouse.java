package com.springboot.designpattern.factory;

public class HpMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("hp mouse click");
    }
}
