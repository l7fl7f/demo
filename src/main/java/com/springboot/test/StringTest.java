package com.springboot.test;


import org.apache.commons.lang3.StringUtils;

public class StringTest {
    public static void main(String[] args) {
        String b = "";
        String c = null;
        String a = " ";
        Object d;
        System.out.println(StringUtils.isEmpty(b));
        System.out.println(StringUtils.isBlank(b));
    }
}
