package com.springboot.designpattern.factory;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse productMouse() {
        return new HpMouse();
    }
}
