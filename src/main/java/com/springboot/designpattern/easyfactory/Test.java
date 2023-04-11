package com.springboot.designpattern.easyfactory;

public class Test {
    public static void main(String[] args) {
        MouseFactory factory = new MouseFactory();
        Mouse mouse = factory.productMouse(0);
        mouse.click();
    }
}
