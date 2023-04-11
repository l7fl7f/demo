package com.springboot.designpattern.abstractfoctory;

public class DellKeyboard implements Keyboard{
    @Override
    public void knock() {
        System.out.println("dell keyboard knock");
    }
}
