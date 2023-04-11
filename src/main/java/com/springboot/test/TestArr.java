package com.springboot.test;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class TestArr {
    public static void main(String[] args) {
//        String s = "N@R@";
//        String[] arr = s.split("@");
//        System.out.println("");
        List<String> list = new ArrayList<>();
        System.out.println(!list.isEmpty());
        String[] a1 = new String[]{"1","3"};
        String[] a2 = new String[]{"2"};
        String[] arr = ArrayUtils.addAll(a1, a2);
        System.out.println(1);
    }
}
