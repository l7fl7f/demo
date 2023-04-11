package com.springboot.read_file;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead6_live_rtp {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\hw_live.txt");
            if (f1.exists()==false){
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                String param1 = sheet.getRow(i).getCell(1).toString();
                String param2 = sheet.getRow(i).getCell(2).toString();
                String param3 = sheet.getRow(i).getCell(3).toString();
                Integer param4 = (int)sheet.getRow(i).getCell(4).getNumericCellValue();
                Integer param5 = (int)sheet.getRow(i).getCell(5).getNumericCellValue();
                String sql = "INSERT INTO `smp_iptv`.`category`(`category_id`, `category_code`, `title`, `category_type`, `pid`, `pcode`, `cp_id`, `status`, `sequence`, `description`, `announce`, `url`, `leaf`, `view_url`, `special_type`, `start_time`, `end_time`, `create_time`, `modify_time`, `biz_domain`) " +
                        "VALUES ('livechannel"+param5+param2+"', 'livechannel"+param5+param2+"', '"+param1+"', '1', 'livearea"+param5+"', 'livearea"+param5+"', '20001082', '0', '1', 'rtp://"+param3+":"+param4+"', '1', '', '0', NULL, '0', '2022-04-19 10:18:05', '2099-12-31 23:59:59', '2022-04-19 10:18:05', '2022-04-19 10:18:05', '0');\n";
                writer1.write(sql);
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
        ExcelRead6_live_rtp.readExcel("C:\\Users\\lqf\\Desktop\\hw_live.xlsx");
    }
}
