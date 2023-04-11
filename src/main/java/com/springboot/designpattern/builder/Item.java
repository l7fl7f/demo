package com.springboot.designpattern.builder;

/**
 * 食物
 */
public interface Item {
    String name();
    Packing packing();
    float price();
}
