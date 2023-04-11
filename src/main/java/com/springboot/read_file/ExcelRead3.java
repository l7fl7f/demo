package com.springboot.read_file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead3 {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\remove_url.txt");
            File f2 = new File("C:\\Users\\lqf\\Desktop\\remove_url.sql");
            File f3 = new File("C:\\Users\\lqf\\Desktop\\remove_temp.sql");
            if (f1.exists()==false){
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            FileWriter writer2 = new FileWriter(f2);
            FileWriter writer3 = new FileWriter(f3);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                // 循环列
                if (null != sheet.getRow(i).getCell(0)) {
                    String id = sheet.getRow(i).getCell(0).toString();
                    String sql1 = "db.urlVod.remove({ \"_id\" : \""+id+"\"});\n";
                    String sql2 = "delete from url_vod where id = \"" + id + "\";\n";
                    String sql3 = "delete from 1_temp where _id = \"" + id + "\";\n";
                    writer1.write(sql1);
                    writer2.write(sql2);
                    writer3.write(sql3);
                }
            }
            writer1.flush();
            writer2.flush();
            writer3.flush();
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
        ExcelRead3.readExcel("C:\\Users\\lqf\\Desktop\\remove.xlsx");
    }
}
