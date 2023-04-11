package com.springboot.designpattern.abstractfoctory;

public class DellFactory extends PcFactory {
    @Override
    public Mouse productMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard productKeyboard() {
        return new DellKeyboard();
    }
}
