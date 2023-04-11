package com.springboot.throwabletest;

public class ControllerTest {
    public int test1(int i, int j) {
        System.out.println("***** 计算开始 *****");
        int temp = 0;
//        try {
            temp = i / j;
//        } catch (Exception e) {
//            System.out.println("xxx");
//        }
        System.out.println("***** 计算结束 *****");
        return temp;
    }

    public static void main(String[] args) {
        ControllerTest controllerTest = new ControllerTest();
        try {
            System.out.println("除法操作：" + controllerTest.test1(10, 0));
        } catch (Exception e) {
            System.out.println("异常产生：" + e);
        }
    }
}
