package com.springboot.test;

import com.springboot.c2.utils.CisExceptionEnum;
import org.apache.commons.lang3.StringUtils;

public class ExceptionTest {
    public static void test1() throws Exception {
        try {
            throw new ParserException(CisExceptionEnum.CMDFILEURL_IS_NOT_FTP + "");
        } catch (Exception e) {
            if (e instanceof ParserException) {
                System.out.println("111");
            }
        }
        System.out.println("222");
    }

    public static void main(String[] args) {
        System.out.println("Token verification failed".replace(" ", "_").toUpperCase());
//        try {
//            test1();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}
