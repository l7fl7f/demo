package com.springboot.read_file;

import ch.qos.logback.core.util.TimeUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelRead {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\insert.sql");
            if (f1.exists() == false) {
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                // 循环列
//                if (null != sheet.getRow(i).getCell(0) && null != sheet.getRow(i).getCell(1)) {
//                    String category_code = sheet.getRow(i).getCell(0).toString();
//                    String media_code = sheet.getRow(i).getCell(1).toString();
//                    String sequence = sheet.getRow(i).getCell(2).toString();
//                    String create = sheet.getRow(i).getCell(3).toString();
//                    String update = sheet.getRow(i).getCell(4).toString();
//                    create = stampToDate(create);
//                    update = stampToDate(update);
//                    String sql = "INSERT INTO `category_vod_mapping`(`category_id`, `category_code`, `media_id`, `media_code`, `sequence`, `create_time`, `modify_time`) " +
//                            "VALUES ('"+category_code+"', '"+category_code+"', '"+media_code+"', '"+media_code+"', '"+sequence+"', '"+create+"', '"+update+"');\n";
//                    writer1.write(sql);
//                }
                if (null != sheet.getRow(i).getCell(0) && null != sheet.getRow(i).getCell(1)) {
                    BigDecimal str0 = new BigDecimal(sheet.getRow(i).getCell(0).toString());
                    int s0 = Integer.parseInt(str0.toPlainString());
                    String str1 = sheet.getRow(i).getCell(1).toString();
                    String sql = "INSERT INTO `bmsdb`.`TS_MENU`(`menu_id`, `menu_name`, `menu_url`, `parent_menu_id`, `menu_code`, `icon_address`, `update_time`, `remark`, `menu_state`, `menu_order`) " +
                            "VALUES (" + s0 + ", '" + str1 + "', '" + str1 + "', 10206, '', '', '2023-03-24 00:00:00', '', '1', " + s0 + ");\n";
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
        ExcelRead.readExcel("C:\\Users\\lqf\\Desktop\\111.xlsx");
    }
}
