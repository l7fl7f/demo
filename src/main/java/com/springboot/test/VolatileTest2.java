package com.springboot.test;

import java.util.concurrent.ThreadPoolExecutor;

public class VolatileTest2 {
    static class A {
        volatile int a = 0;

        void increase() {
            a++;
        }

        int getA() {
            return a;
        }
    }

    public static void main(String[] args) {
        try {
            A a = new A();

            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    a.increase();
                }
                System.out.println(a.getA());
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 20000; i++) {
                    a.increase();
                }
                System.out.println(a.getA());
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 30000; i++) {
                    a.increase();
                }
                System.out.println(a.getA());
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 40000; i++) {
                    a.increase();
                }
                System.out.println(a.getA());
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 50000; i++) {
                    a.increase();
                }
                System.out.println(a.getA());
            }).start();

            Thread.sleep(10000);
            System.out.println(a.getA());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

