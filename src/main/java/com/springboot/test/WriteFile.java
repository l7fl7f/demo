package com.springboot.test;

import java.io.*;

public class WriteFile {

    public static void createCommandXmlFile (String xml, String cmdFilePath) throws Exception {
        //获取指令文件保存路径
        File file = new File(cmdFilePath);
        OutputStream out = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
            bw.write(xml);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {

            createCommandXmlFile("111", "C:\\Users\\lqf\\Desktop\\111\\test.txt");
        } catch (Exception e) {

        }
    }
}
