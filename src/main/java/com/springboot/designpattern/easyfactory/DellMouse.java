package com.springboot.designpattern.easyfactory;

public class DellMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("dell mouse click");
    }
}
