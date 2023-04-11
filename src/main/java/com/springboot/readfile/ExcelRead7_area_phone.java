package com.springboot.readfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead7_area_phone {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\insert.txt");
            if (f1.exists()==false){
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                if (null != sheet.getRow(i).getCell(0)) {
                    String phone = sheet.getRow(i).getCell(0).toString();
                    if (phone.endsWith(".0")) {
                        phone = phone.substring(0, phone.indexOf(".0"));
                    }
                    String areaCode = sheet.getRow(i).getCell(1).toString();
                    if (areaCode.endsWith(".0")) {
                        areaCode = areaCode.substring(0, areaCode.indexOf(".0"));
                    }
                    String areaName = sheet.getRow(i).getCell(2).toString();
                    areaName = areaName.trim();
                    String sql = "INSERT INTO `area_phone_map`(`phonePrefix`, `areaCode`, `areaName`) " +
                            "VALUES ('"+phone+"', '"+areaCode+"', '"+areaName+"');\n";
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
        ExcelRead7_area_phone.readExcel("C:\\Users\\lqf\\Desktop\\四川2022年第1批CDMA网H码汇总表-20220805.xlsx");
    }
}
