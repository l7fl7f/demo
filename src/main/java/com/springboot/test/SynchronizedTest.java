package com.springboot.test;

public class SynchronizedTest implements Runnable {
    public static int count = 0;

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedTest());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2);
        System.out.println(l2 - l1);
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100000000; i++)
                count++;
        }
    }
}