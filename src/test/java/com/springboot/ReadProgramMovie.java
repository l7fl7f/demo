package com.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.c2.entity.EpgMovie;
import com.springboot.c2.entity.EpgProgramMovieMapping;
import com.springboot.c2.entity.Movie;
import com.springboot.c2.entity.ProgramMovieMapping;
import com.springboot.c2.service.IMovieService;
import com.springboot.c2.service.IProgramMovieService;
import com.springboot.c2.utils.MyBatisModelSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class ReadProgramMovie {
    @Autowired
    private IProgramMovieService iProgramMovieService;

    @Test
    public void txtTest() {
        String fileName = "C:\\Users\\lqf\\Desktop\\program_movie_mapping.txt";
        this.readFileByLines(fileName);
    }

    public void readFileByLines(String fileName) {
        Long startTime = System.currentTimeMillis();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            // 写文件
            FileOutputStream fileOutputStream = null;
            File wfile = new File("C:\\Users\\lqf\\Desktop\\mongo_program_movie.txt");
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
                    Long endTime = System.currentTimeMillis();
                    System.out.println((endTime - startTime) / 1000);
                }
                String[] arr = tempString.split("\\|");
                String jsonStr = this.publishProgramMovieMapping(arr[0], arr[1], "REGIST");
                if (!"".equals(jsonStr)) {
                    jsonStr = "db.programMovieMapping.save("+jsonStr+");\n";
                    content = content + jsonStr;
                }
                // 避免内存不足，速度太慢，每一部分写一次文件
                if (i % 100 == 0) {
                    fileOutputStream.write(content.getBytes());
                    content = "";
                }
            }
            System.out.println(i);
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

    public String publishProgramMovieMapping(String movieCode, String programCode, String action) {
        String jsonStr = "";
        try {
            EpgProgramMovieMapping epgProgramMovieMapping = null;
            MyBatisModelSetup setup = new MyBatisModelSetup();
            setup.addParameter("movieCode", movieCode);
            setup.addParameter("programCode", programCode);
            List<ProgramMovieMapping> programMovieMappingList = iProgramMovieService.getAll(setup);
            if (null != programMovieMappingList && programMovieMappingList.size() > 0) {
                epgProgramMovieMapping = this.getEpgProgramMovieMapping(programMovieMappingList.get(0));
                if (null != epgProgramMovieMapping && !"".equals(epgProgramMovieMapping.getId())) {
                    jsonStr = JSONObject.toJSONString(epgProgramMovieMapping);
                    jsonStr = jsonStr.replace("\"id\"", "\"_id\"");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public EpgProgramMovieMapping getEpgProgramMovieMapping(ProgramMovieMapping programMovieMapping) {
        EpgProgramMovieMapping epgProgramMovieMapping = new EpgProgramMovieMapping();
        epgProgramMovieMapping.setId(programMovieMapping.getId());
        epgProgramMovieMapping.setElementType(programMovieMapping.getElementType());
        epgProgramMovieMapping.setMovieCode(programMovieMapping.getMovieCode());
        epgProgramMovieMapping.setMovieId(programMovieMapping.getMovieId());
        epgProgramMovieMapping.setParentType(programMovieMapping.getParentType());
        epgProgramMovieMapping.setProvider(programMovieMapping.getProvider());
        epgProgramMovieMapping.setProgramCode(programMovieMapping.getProgramCode());
        epgProgramMovieMapping.setProgramId(programMovieMapping.getProgramId());
        epgProgramMovieMapping.setMessageId(programMovieMapping.getMessageId());
        epgProgramMovieMapping.setStatus(programMovieMapping.getStatus());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        epgProgramMovieMapping.setCreateTime(formatter.format(programMovieMapping.getCreateTime()));
        epgProgramMovieMapping.setUpdateTime(formatter.format(programMovieMapping.getUpdateTime()));
        return epgProgramMovieMapping;
    }

    public Map<String, List<Map<String, String>>> getMapList(List<Map<String, String>> listMap, String key, String value) {
        Map map = new HashMap();
        if (listMap != null && listMap.size() > 0) {
            for (Map<String, String> imgMap : listMap) {
                String jsonArr = imgMap.get(value);
                List<Object> list = new ArrayList<>();
                try {
                    list = JSON.parseArray(jsonArr);
                } catch (Exception e) {
                    System.out.println(jsonArr);
                }
                List<Map<String, String>> listw = new ArrayList<Map<String, String>>();
                if (list != null) {
                    for (Object object : list) {
                        Map<String, String> ret = (Map<String, String>) object;
                        listw.add(ret);
                    }
                }
                map.put(imgMap.get(key), listw);
            }
        }
        return map;
    }
}
