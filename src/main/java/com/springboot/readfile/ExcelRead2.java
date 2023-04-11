package com.springboot.readfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead2 {
    public static List<List<String>> readExcel(String path) {
        // 读取excel文件
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            // 获取工作薄
            Workbook wb = null;
            // 文件类型
            String fileType = path.substring(path.lastIndexOf(".") + 1);
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }
            // 读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            // 循环行
            File f1 = new File("C:\\Users\\lqf\\Desktop\\save_url.txt");
            if (f1.exists()==false){
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                // 循环列
                if (null != sheet.getRow(i).getCell(0) && null != sheet.getRow(i).getCell(1)) {
                    String id = sheet.getRow(i).getCell(0).toString();
                    String movie_id = sheet.getRow(i).getCell(1).toString();
                    String media_id = sheet.getRow(i).getCell(2).toString();
                    String type = "";
                    if (null != sheet.getRow(i).getCell(3)) {
                        type = sheet.getRow(i).getCell(3).toString();
                    }
                    String duration = "";
                    if (null != sheet.getRow(i).getCell(4)) {
                        duration = sheet.getRow(i).getCell(4).toString();
                    }
                    String video_format = "";
                    if (null != sheet.getRow(i).getCell(5)) {
                        video_format = sheet.getRow(i).getCell(5).toString();
                    }
                    String provider_id = "";
                    if (null != sheet.getRow(i).getCell(6)) {
                        provider_id = sheet.getRow(i).getCell(6).toString();
                    }
                    String title = "";
                    if (null != sheet.getRow(i).getCell(7)) {
                        title = sheet.getRow(i).getCell(7).toString();
                    }

                    String sql = "db.urlVod.save({ \"_id\" : \""+id+"\", \"movieId\" : \""+movie_id+"\", \"movieCode\" : \""+movie_id+"\", \"mediaId\" : \""+media_id+"\", \"mediaCode\" : \""+media_id+"\", \"programId\" : \"\", \"screenCode\" : \"\", \"type\" : \""+type+"\", \"url\" : \"\", \"serial\" : \"\", \"sourceDrmType\" : \"\", \"destDrmType\" : \"\", \"audioType\" : \"\", \"screenFormat\" : \"\", \"closedCaptioning\" : \"\", \"duration\" : \""+duration+"\", \"fileSize\" : \"\", \"bitrate\" : \"\", \"videoType\" : \"\", \"audioFormat\" : \"\", \"resolution\" : \"\", \"videoProfile\" : \"\", \"videoFormat\" : \""+video_format+"\", \"serviceType\" : \"\", \"movieHeadDuration\" : \"\", \"movieTailDuration\" : \"\", \"cpId\" : \""+provider_id+"\", \"cpName\" : \"\", \"price\" : 0, \"title\" : \""+title+"\", \"description\" : \"\", \"images\" : {  }, \"cast\" : {  }, \"bizDomain\" : \"0\", \"_class\" : \"com.iptv.epg.core.entity.content.UrlVod\" });\n";
                    writer1.write(sql);
                }
            }
            writer1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ExcelRead2.readExcel("C:\\Users\\lqf\\Desktop\\3.xlsx");
    }
}
