package com.springboot.readfile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelRead4 {
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
            File f1 = new File("C:\\Users\\lqf\\Desktop\\20002038.sql");
            if (f1.exists()==false){
                f1.getParentFile().mkdirs();
            }
            // 创建基于文件的输出流
            FileWriter writer1 = new FileWriter(f1);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                // 循环列
                if (null != sheet.getRow(i).getCell(0)) {
                    String param1 = sheet.getRow(i).getCell(0).toString();
                    String param2 = sheet.getRow(i).getCell(1).toString();
                    String sql = "update url_vod set media_id = '"+param1+"', media_code = '"+param1+"' where movie_code = '"+param2+"' and ((media_code is null or media_code = '') and program_id is null);\n";
                    String sql1 = "INSERT INTO `smp_iptv`.`url_vod`(`id`, `movie_id`, `movie_code`, `media_id`, `media_code`, `program_id`, `screen_code`, `type`, `url`, `serial`, `source_drm_type`, `dest_drm_type`, `audio_type`, `screen_format`, `closed_captioning`, `duration`, `file_size`, `bitrate`, `video_type`, `audio_format`, `resolution`, `video_profile`, `video_format`, `service_type`, `movie_head_duration`, `movie_tail_duration`, `provider_id`, `thumbnail_url`, `image_url`, `title`, `description`, `area_id`, `release_time`, `create_time`, `modify_time`, `biz_domain`) " +
                            "VALUES ('import_20210413_"+param2+"', '"+param2+"', '"+param2+"', '"+param1+"', '"+param1+"', NULL, NULL, '1', NULL, '1', '0', '0', '0', '0', '0', '010000', '9999', '1', '1', '1', '1', '1', '1.ts', '0x01', NULL, NULL, '20002038', NULL, NULL, '不要', NULL, NULL, NULL, '2021-04-13 00:00:00', '2021-04-13 00:00:00', '0');\n";
                    writer1.write(sql1);
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
        ExcelRead4.readExcel("C:\\Users\\lqf\\Desktop\\20002038.xlsx");
    }
}
