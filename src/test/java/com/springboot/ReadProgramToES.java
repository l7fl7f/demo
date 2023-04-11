package com.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.c2.entity.*;
import com.springboot.c2.service.*;
import com.springboot.c2.utils.MyBatisModelSetup;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class ReadProgramToES {
    @Autowired
    private IProgramService iProgramService;
    @Autowired
    private IMediaServiceMappingService iMediaServiceMappingService;
    @Autowired
    private ICpspInfoService iCpspInfoService;
    @Autowired
    private ICategoryVodMappingService iCategoryVodMappingService;
    @Autowired
    private IImageMediaMappingService iImageMediaMappingService;
    @Autowired
    private IMovieService iMovieService;

    @Test
    public void txtTest() {
        String fileName = "C:\\Users\\lqf\\Desktop\\program.txt";
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
            File wfile = new File("C:\\Users\\lqf\\Desktop\\es_program.txt");
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
                String jsonStr = this.publishSearchData(tempString);
                if (!"".equals(jsonStr)) {
                    jsonStr = "{\"index\":{\"_index\":\"content\",\"_type\":\"contentInfo\"}}\n" + jsonStr + "\n";
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

    public String publishSearchData(String code) {
        String jsonStr = "";
        try {
            EpgUnifiedSearch epgUnifiedSearch = null;
            MyBatisModelSetup setup = new MyBatisModelSetup();
            setup.addParameter("code", code);
            List<Program> programList = iProgramService.getAll(setup);
            if (null != programList && programList.size() > 0) {
                epgUnifiedSearch = this.getEpgUnifiedSearch(programList.get(0));
                if (null != epgUnifiedSearch && !"".equals(epgUnifiedSearch.getCode())) {
                    jsonStr = JSONObject.toJSONString(epgUnifiedSearch);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    private EpgUnifiedSearch getEpgUnifiedSearch(Program program) {
        EpgUnifiedSearch epgUnifiedSearch = new EpgUnifiedSearch();
        String code = program.getCode();
        String name = program.getName();
        epgUnifiedSearch.setCode(code);
        epgUnifiedSearch.setName(name);
        epgUnifiedSearch.setCspId(program.getProvider());
        List<CpspInfo> cpspInfoList = iCpspInfoService.fingByCpIdOrName(program.getProvider(), "");
        if (null != cpspInfoList && cpspInfoList.size() > 0) {
            epgUnifiedSearch.setCspName(cpspInfoList.get(0).getName());
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        epgUnifiedSearch.setUpdateTime(df.format(new Date()));
        epgUnifiedSearch.setType5(2);
        epgUnifiedSearch.setDuring(0);

        epgUnifiedSearch.setSeriesFlag(0);
        if ("1".equals(program.getSeriesFlag())) {
            epgUnifiedSearch.setSeriesFlag(99);
        }
        epgUnifiedSearch.setUpdateTime(df.format(program.getUpdateTime()));
        // 时长
        MyBatisModelSetup setup = new MyBatisModelSetup();
        setup = new MyBatisModelSetup();
        setup.addParameter("programCode", code);
        List<Movie> movieList = iMovieService.selectByProgram(setup);
        if (!movieList.isEmpty()) {
            if (null != movieList.get(0).getDuration() && isInteger(movieList.get(0).getDuration())) {
                if (movieList.get(0).getDuration().length() == 6 || movieList.get(0).getDuration().length() == 8) {
                    String duration = movieList.get(0).getDuration();
                    int dur = 3600 * Integer.parseInt(duration.substring(0, 2)) + 60 * Integer.parseInt(duration.substring(2, 4) + Integer.parseInt(duration.substring(4, 6)));
                    epgUnifiedSearch.setDuring(dur);
                }
            }
            epgUnifiedSearch.setType5(1);
        }

        epgUnifiedSearch.setReleaseYear(0);
        String releaseYear = program.getReleaseYear();
        if (!"".equals(releaseYear) && isInteger(releaseYear)) {
            epgUnifiedSearch.setReleaseYear(Integer.parseInt(releaseYear));
        }
        epgUnifiedSearch.setLicensingWindowEnd(program.getLicensingWindowEnd());
        epgUnifiedSearch.setOriginalCountry(program.getOriginalCountry());
        epgUnifiedSearch.setGener(program.getGenre());
        epgUnifiedSearch.setTags(program.getTags());
        epgUnifiedSearch.setKeyword(program.getSearchName().toUpperCase());
        epgUnifiedSearch.setSeriesChild(2);
        epgUnifiedSearch.setNameLength(name.length());
        List<Map<String, String>> mapList = iImageMediaMappingService.getImgListMap(program.getId());
        epgUnifiedSearch.setPicture(this.getMapList(mapList, "img_type", "images"));
        epgUnifiedSearch.setContentScore(0);
        String contentScore = program.getContentScore();
        if (!"".equals(contentScore) && isInteger(contentScore)) {
            epgUnifiedSearch.setContentScore(Integer.parseInt(contentScore));
        }
        epgUnifiedSearch.setPv(0);
        String playCount = program.getUseTimes();
        if (!"".equals(playCount) && isInteger(playCount)) {
            epgUnifiedSearch.setPv(Integer.parseInt(playCount));
        }

        epgUnifiedSearch.setType1(2);
        Pattern p = Pattern.compile("^[0-9].*");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            epgUnifiedSearch.setType1(1);
        }
        epgUnifiedSearch.setType2(2);
        List<String> searchSpecialwordsList = new ArrayList<>();
        searchSpecialwordsList.add("优朋");
        searchSpecialwordsList.add("高清");
        searchSpecialwordsList.add("百事通");
        searchSpecialwordsList.add("HD");
        searchSpecialwordsList.add("720P");
        searchSpecialwordsList.add("1080P");
        searchSpecialwordsList.add("测试");
        searchSpecialwordsList.add("ceshi");
        searchSpecialwordsList.add("NEW");
        searchSpecialwordsList.add("new");
        searchSpecialwordsList.add("MTV");
        if (!searchSpecialwordsList.isEmpty()) {
            for (int i = 0; i < searchSpecialwordsList.size(); i++) {
                if (name.contains(searchSpecialwordsList.get(i))) {
                    epgUnifiedSearch.setType4(1);
                    break;
                }
            }
        }
        epgUnifiedSearch.setType3(2);
        setup = new MyBatisModelSetup();
        setup.addParameter("mediaCode", code);
        List<MediaServiceMapping> mediaServiceMappingList = iMediaServiceMappingService.getAll(setup);
        if (!mediaServiceMappingList.isEmpty()) {
            epgUnifiedSearch.setType3(1);
        }
        epgUnifiedSearch.setType4(2);
        List<CategoryVodMapping> categoryVodMappingList = iCategoryVodMappingService.getByMediaCode(code);
        if (categoryVodMappingList.size() > 0) {
            epgUnifiedSearch.setType4(1);
        }
        epgUnifiedSearch.setType6(2);
        epgUnifiedSearch.setType7(2);
        epgUnifiedSearch.setType8(2);
        epgUnifiedSearch.setType9(2);
        return epgUnifiedSearch;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
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
