package com.springboot.designpattern.abstractfoctory;

public class HpKeyboard implements Keyboard {
    @Override
    public void knock() {
        System.out.println("hp keyboard knock");
    }
}
