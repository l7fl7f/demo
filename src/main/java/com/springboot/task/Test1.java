package com.springboot.task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private static long start = System.currentTimeMillis();

    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();



    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println("time wait:"+(end-start)+",this is 线程1");
        },"线程1");

        Thread thread2 = new Thread(() -> {
            long end = System.currentTimeMillis();
            System.out.println("time wait:"+(end-start)+",this is 线程2");
        },"线程2");

        Thread thread3 = new Thread(() -> {
            long end = System.currentTimeMillis();
            System.out.println("time wait:"+(end-start)+",this is 线程3");
        },"线程3");
        executor.scheduleWithFixedDelay(thread1,0, 1 , TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(thread2,0, 2 , TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(thread3,0, 3 , TimeUnit.SECONDS);
    }
}
