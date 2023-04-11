package com.springboot.designpattern.abstractfoctory;

public class HpFactory extends PcFactory {
    @Override
    public Mouse productMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard productKeyboard() {
        return new HpKeyboard();
    }
}
