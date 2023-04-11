package com.springboot.test;

import com.springboot.utils.Hash163;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hash163Test {
    public static void main(String[] args) {
        String tableName = "";
        try {
            tableName = Hash163.USERHash("guest1657260582526062", Hash163.USERINFO_TABLE_HEAD);
        } catch (Exception e) {

        }
        System.out.println(tableName);
    }
}
