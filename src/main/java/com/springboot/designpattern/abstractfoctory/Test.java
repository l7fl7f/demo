package com.springboot.designpattern.abstractfoctory;

public class Test {
    public static void main(String[] args) {
        PcFactory factory1 = new DellFactory();
        PcFactory factory2 = new HpFactory();
        Mouse mouse = factory1.productMouse();
        Keyboard keyboard = factory2.productKeyboard();
        mouse.click();
        keyboard.knock();
    }
}
