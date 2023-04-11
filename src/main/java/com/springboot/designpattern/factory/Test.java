package com.springboot.designpattern.factory;

public class Test {
    public static void main(String[] args) {
        MouseFactory factory = new DellMouseFactory();
        Mouse mouse = factory.productMouse();
        mouse.click();
    }
}
