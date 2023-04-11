package com.springboot.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileContrastTest {
    public static void main(String[] args) {
        String left = "C:\\Users\\lqf\\Desktop\\250";
        String right = "C:\\Users\\lqf\\Desktop\\251";

        File fileLeft = new File(left);
        File fileRight = new File(right);

        File[] arrLeft = fileLeft.listFiles();
        File[] arrRight = fileRight.listFiles();

        List<Map> list = new ArrayList<>();

        // 两边文件数量可能不一致所以分两种情况
        if (arrLeft.length >= arrRight.length) {
            for (int i = 0; i < arrLeft.length; i++) {
                int flag = -1;
                for (int j = 0; j < arrRight.length; j++) {
                    if (arrLeft[i].getName().equals(arrRight[j].getName()) && arrLeft[i].isDirectory() == arrRight[j].isDirectory()) {
                        flag = j;
                        break;
                    }
                }
                Map map = new HashMap();
                map.put("fileNameLeft", arrLeft[i].getName());
                map.put("filePathLeft", arrLeft[i].getAbsolutePath());
                if (arrLeft[i].isDirectory()) {
                    map.put("isDirLeft", "1");
                } else {
                    map.put("isDirLeft", "0");
                }
                if (flag >= 0) {
                    map.put("fileNameRight", arrRight[flag].getName());
                    map.put("filePathRight", arrRight[flag].getAbsolutePath());
                    if (arrRight[flag].isDirectory()) {
                        map.put("isDirRight", "1");
                    } else {
                        map.put("isDirRight", "0");
                    }
                    if (FileMD5Util.getMD5(arrLeft[i]).equals(FileMD5Util.getMD5(arrRight[flag]))) {
                        map.put("contrastResult", "1");
                    } else {
                        map.put("contrastResult", "0");
                    }
                } else {
                    map.put("fileNameRight", "");
                    map.put("filePathRight", "");
                    map.put("isDirRight", "");
                    map.put("contrastResult", "0");
                }
                list.add(map);
            }
        } else {
            for (int i = 0; i < arrRight.length; i++) {
                int flag = -1;
                for (int j = 0; j < arrLeft.length; j++) {
                    if (arrRight[i].getName().equals(arrLeft[j].getName()) && arrRight[i].isDirectory() == arrLeft[j].isDirectory()) {
                        flag = j;
                        break;
                    }
                }
                Map map = new HashMap();
                map.put("fileNameRight", arrRight[i].getName());
                map.put("filePathRight", arrRight[i].getAbsolutePath());
                if (arrRight[i].isDirectory()) {
                    map.put("isDirRight", "1");
                } else {
                    map.put("isDirRight", "0");
                }
                if (flag >= 0) {
                    map.put("fileNameLeft", arrLeft[flag].getName());
                    map.put("filePathLeft", arrLeft[flag].getAbsolutePath());
                    if (arrLeft[flag].isDirectory()) {
                        map.put("isDirLeft", "1");
                    } else {
                        map.put("isDirLeft", "0");
                    }
                    if (FileMD5Util.getMD5(arrRight[i]).equals(FileMD5Util.getMD5(arrLeft[flag]))) {
                        map.put("contrastResult", "1");
                    } else {
                        map.put("contrastResult", "0");
                    }
                } else {
                    map.put("fileNameLeft", "");
                    map.put("filePathLeft", "");
                    map.put("isDirLeft", "");
                    map.put("contrastResult", "0");
                }
                list.add(map);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("fileNameLeft"));
            System.out.println(list.get(i).get("filePathLeft"));
            System.out.println(list.get(i).get("fileNameRight"));
            System.out.println(list.get(i).get("filePathRight"));
            System.out.println(list.get(i).get("isDirLeft"));
            System.out.println(list.get(i).get("isDirRight"));
            System.out.println(list.get(i).get("contrastResult"));
        }
    }
}
