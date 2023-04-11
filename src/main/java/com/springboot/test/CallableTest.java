package com.springboot.test;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {


    private String name;

    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }
}