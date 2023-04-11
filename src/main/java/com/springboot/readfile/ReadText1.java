package com.springboot.readfile;

import java.io.*;

public class ReadText1 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\lqf\\Downloads\\1\\1.sql";
        ReadText1.readFileByLines(fileName);
    }

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            String content = "";
            while ((tempString = reader.readLine()) != null) {
                String[] arr = tempString.split("\\|");
                String sql = "";
                if (arr.length == 9) {
                    sql = "db.urlVod.insert({ \"_id\" : \"" + arr[0] + "\", \"movieId\" : \"" + arr[1] + "\", \"movieCode\" : \"" + arr[2] + "\", \"mediaId\" : \"" + arr[3] + "\", \"mediaCode\" : \"" + arr[4] + "\", \"programId\" : \"\", \"screenCode\" : \"\", \"type\" : " + arr[5] + ", \"url\" : \"\", \"serial\" : \"\", \"sourceDrmType\" : \"\", \"destDrmType\" : \"\", \"audioType\" : \"\", \"screenFormat\" : \"\", \"closedCaptioning\" : \"\", \"duration\" : \"" + arr[6] + "\", \"fileSize\" : \"\", \"bitrate\" : \"\", \"videoType\" : \"\", \"audioFormat\" : \"\", \"resolution\" : \"\", \"videoProfile\" : \"\", \"videoFormat\" : \"." + arr[7] + "\", \"serviceType\" : \"\", \"movieHeadDuration\" : \"\", \"movieTailDuration\" : \"\", \"cpId\" : \"" + arr[8] + "\", \"cpName\" : \"\", \"price\" : 0, \"title\" : \"\", \"description\" : \"\", \"images\" : {  }, \"cast\" : {  }, \"bizDomain\" : \"0\", \"_class\" : \"com.iptv.epg.core.entity.content.UrlVod\" });\n";
                } else if (arr.length == 10) {
                    sql = "db.urlVod.insert({ \"_id\" : \"" + arr[0] + "\", \"movieId\" : \"" + arr[1] + "\", \"movieCode\" : \"" + arr[2] + "\", \"mediaId\" : \"" + arr[3] + "\", \"mediaCode\" : \"" + arr[4] + "\", \"programId\" : \"\", \"screenCode\" : \"\", \"type\" : " + arr[5] + ", \"url\" : \"\", \"serial\" : \"\", \"sourceDrmType\" : \"\", \"destDrmType\" : \"\", \"audioType\" : \"\", \"screenFormat\" : \"\", \"closedCaptioning\" : \"\", \"duration\" : \"" + arr[6] + "\", \"fileSize\" : \"\", \"bitrate\" : \"\", \"videoType\" : \"\", \"audioFormat\" : \"\", \"resolution\" : \"\", \"videoProfile\" : \"\", \"videoFormat\" : \"." + arr[7] + "\", \"serviceType\" : \"\", \"movieHeadDuration\" : \"\", \"movieTailDuration\" : \"\", \"cpId\" : \"" + arr[8] + "\", \"cpName\" : \"\", \"price\" : 0, \"title\" : \"" + arr[9] + "\", \"description\" : \"\", \"images\" : {  }, \"cast\" : {  }, \"bizDomain\" : \"0\", \"_class\" : \"com.iptv.epg.core.entity.content.UrlVod\" });\n";
                }
                content = content + sql;
            }
            reader.close();
            // 写文件
            FileOutputStream fileOutputStream = null;
            File wfile = new File("C:\\Users\\lqf\\Downloads\\1\\1.txt");
            if (wfile.exists()) {
                //判断文件是否存在，如果不存在就新建一个txt
                wfile.createNewFile();
            }
            fileOutputStream = new FileOutputStream(wfile);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
