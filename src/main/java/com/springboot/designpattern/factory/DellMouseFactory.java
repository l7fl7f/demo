package com.springboot.designpattern.factory;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse productMouse() {
        return new DellMouse();
    }
}
