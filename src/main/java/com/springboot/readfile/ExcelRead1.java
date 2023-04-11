package com.springboot.readfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead1 {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\insert_url.sql");
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
                    String type = sheet.getRow(i).getCell(3).toString();
                    String duration = sheet.getRow(i).getCell(4).toString();
                    String video_format = sheet.getRow(i).getCell(5).toString();
                    String provider_id = sheet.getRow(i).getCell(6).toString();
                    String title = sheet.getRow(i).getCell(7).toString();

                    String sql = "INSERT INTO `smp_iptv`.`url_vod`(`id`, `movie_id`, `movie_code`, `media_id`, `media_code`, `program_id`, `screen_code`, `type`, `url`, `serial`, `source_drm_type`, `dest_drm_type`, `audio_type`, `screen_format`, `closed_captioning`, `duration`, `file_size`, `bitrate`, `video_type`, `audio_format`, `resolution`, `video_profile`, `video_format`, `service_type`, `movie_head_duration`, `movie_tail_duration`, `provider_id`, `thumbnail_url`, `image_url`, `title`, `description`, `area_id`, `release_time`, `create_time`, `modify_time`, `biz_domain`) " +
                            "VALUES ('"+id+"_1', '"+movie_id+"', '"+movie_id+"', '9B79AAD109BF4EE2BFDF653E71B25412', '9B79AAD109BF4EE2BFDF653E71B25412', '"+media_id+"', '', '"+type+"', '', '', '', '', '', '', '', '"+duration+"', '', '', '', '', '', '', '"+video_format+"', '', '', '', '"+provider_id+"', '', '', '"+title+"', '', '', '', '2020-12-18 00:00:00', '2020-12-18 00:00:00', '0');\n";

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
        ExcelRead1.readExcel("C:\\Users\\lqf\\Desktop\\20001044.xlsx");
    }
}
