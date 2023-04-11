package com.springboot.test;

import com.springboot.c2.entity.SeriesProgramMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MatchTest {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("^[0-9].*");
//        Matcher m = p.matcher("7");
//        System.out.println(m.matches());
//        List<String> list = null;
//        System.out.println(list.isEmpty());
//        String s = ".";
//        System.out.println(s.split("\\.").length);
//        List<String> list = new ArrayList<>();
//        if (null != list && list.size() > 0) {
//            System.out.println("1");
//        } else {
//            System.out.println("0");
//        }

//            File targetFolder = new File("C:\\Users\\lqf\\Downloads\\scdx\\1\\");
//            ZipInputStream zi = new ZipInputStream(new FileInputStream("C:\\Users\\lqf\\Downloads\\scdx\\scdx\\waterfall\\images\\nav"));
//            ZipEntry ze = null;
//            FileOutputStream fo = null;
//            byte[] buff = new byte[1024 * 10];
//            int len;
//            while ((ze = zi.getNextEntry()) != null) {
//                File _file = new File(targetFolder, ze.getName());
//                if (!_file.getParentFile().exists()) {
//                    _file.getParentFile().mkdirs();
//                }
//                if (ze.isDirectory()) {
//                    _file.mkdir();
//                } else {
//                    fo = new FileOutputStream(_file);
//                    while ((len = zi.read(buff)) > 0) fo.write(buff, 0, len);
//                    fo.close();
//                }
//                zi.closeEntry();
//            }
//            zi.close();
//        System.out.println("".charAt(0));


        System.out.println(isInteger("00:11"));
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}
