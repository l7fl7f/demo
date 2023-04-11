package com.springboot.designpattern.easyfactory;

public class HpMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("hp mouse click");
    }
}
