package com.springboot.read_file;

import java.io.*;

public class ReadText {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\lqf\\Desktop\\File_3.0";
        ReadText.readFileByLines(fileName);
    }

    public static void readFileByLines(String fileName) {
        Long startTime = System.currentTimeMillis();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            // 写文件
            FileOutputStream fileOutputStream = null;
            File wfile = new File("C:\\Users\\lqf\\Desktop\\9.txt");
            if (wfile.exists()) {
                //判断文件是否存在，如果不存在就新建一个txt
                wfile.createNewFile();
            }
            fileOutputStream = new FileOutputStream(wfile);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            int i = 0;
            String content = "";
            while ((tempString = reader.readLine()) != null) {
                i++;
                if (i % 10000 == 0) {
                    System.out.println(i);
                }
                String[] arr = tempString.split("\\|");
                String str = "LPUSH " + arr[0] + " \"\\\"{\\\\\\\"productId\\\\\\\":\\\\\\\""+arr[1]+"\\\\\\\",\\\\\\\"createTime\\\\\\\":\\\\\\\"20210729000000\\\\\\\",\\\\\\\"startEffectTime\\\\\\\":\\\\\\\""+arr[4]+"\\\\\\\",\\\\\\\"endEffectTime\\\\\\\":\\\\\\\""+arr[5]+"\\\\\\\",\\\\\\\"updateTime\\\\\\\":\\\\\\\"20210729000000\\\\\\\",\\\\\\\"sevenDaysFrontOrder\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"tenDaysAfterOrder\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"spId\\\\\\\":\\\\\\\""+arr[3]+"\\\\\\\",\\\\\\\"productName\\\\\\\":\\\\\\\""+arr[2]+"\\\\\\\"}\\\"\"\n";
                content = content + str;
                // 避免内存不足，速度太慢，每一万条写一次文件
                if (i % 1000 == 0) {
                    fileOutputStream.write(content.getBytes());
                    content = "";
                }
            }
            fileOutputStream.write(content.getBytes());
            reader.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Long endTime = System.currentTimeMillis();
            System.out.println("done");
            System.out.println((endTime - startTime) / 1000);
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
