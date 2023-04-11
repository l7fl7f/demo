package com.springboot.test;

public class NewClassTest {
    private static int n = 1;

    public static void main(String[] args) {
        NewClassTest t1 = new NewClassTest();
        t1.n = 2;
        NewClassTest t2 = new NewClassTest();
        System.out.println(t2.n);

    }
}
