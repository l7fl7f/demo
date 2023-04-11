package com.springboot.designpattern.easyfactory;

public class MouseFactory {
    public Mouse productMouse(int type) {
        switch (type) {
            case 0:
                return new DellMouse();
            case 1:
                return new HpMouse();
            default:
                return null;
        }

    }
}
