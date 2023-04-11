package com.springboot.c2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.SpringbootApplication;
import com.springboot.c2.entity.*;
import com.springboot.c2.service.*;
import com.springboot.c2.utils.MyBatisModelSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
//@Order(value = 1)
public class ReadSeriseToES implements CommandLineRunner {
    @Autowired
    private ISeriesService iSeriesService;
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
    @Autowired
    private ISeriesProgramService iSeriesProgramService;
    @Autowired
    private ICpPlateService iCpPlateService;

    static Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

    @Override
    public void run(String... var1) {
        String fileName = "/syiptv/work/lqf/series.txt";
        Long startTime = System.currentTimeMillis();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            // 写文件
            FileOutputStream fileOutputStream = null;
            File wfile = new File("/syiptv/work/lqf/es_series.txt");
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
                    jsonStr = "{\"index\":{\"_index\":\"content\",\"_type\":\"contentInfo\",\"_id\":\""+tempString+"\"}}\n" + jsonStr + "\n";
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
            ProcessBuilder pb = new ProcessBuilder("./bulk.sh", "es_series.txt");
            pb.directory(new File("/syiptv/work/lqf/"));
            pb.redirectErrorStream(true);
        }
    }

    public String publishSearchData(String code) {
        String jsonStr = "";
        try {
            EpgUnifiedSearch epgUnifiedSearch = null;
            MyBatisModelSetup setup = new MyBatisModelSetup();
            setup.addParameter("code", code);
            List<Series> seriesList = iSeriesService.getAll(setup);
            if (null != seriesList && seriesList.size() > 0) {
                epgUnifiedSearch = this.getEpgUnifiedSearch(seriesList.get(0));
                if (null != epgUnifiedSearch && !"".equals(epgUnifiedSearch.getCode())) {
                    jsonStr = JSONObject.toJSONString(epgUnifiedSearch);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    private EpgUnifiedSearch getEpgUnifiedSearch(Series series) {
        EpgUnifiedSearch epgUnifiedSearch = new EpgUnifiedSearch();
        String code = series.getCode();
        String name = series.getName();
        epgUnifiedSearch.setCode(code);
        epgUnifiedSearch.setName(name);
        epgUnifiedSearch.setCspId(series.getProvider());
        List<CpspInfo> cpspInfoList = iCpspInfoService.fingByCpIdOrName(series.getProvider(), "");
        if (null != cpspInfoList && cpspInfoList.size() > 0) {
            epgUnifiedSearch.setCspName(cpspInfoList.get(0).getName());
        }

        epgUnifiedSearch.setPlate("");
        epgUnifiedSearch.setChannel("");
        List<CpPlate> cpPlates = iCpPlateService.selectByCpId(series.getProvider());
        if (!cpPlates.isEmpty()) {
            epgUnifiedSearch.setPlate(cpPlates.get(0).getPlate());
            epgUnifiedSearch.setChannel(cpPlates.get(0).getChannel());
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        epgUnifiedSearch.setType5(2);
        epgUnifiedSearch.setDuring(0);
        epgUnifiedSearch.setUpdateTime(df.format(new Date()));
        epgUnifiedSearch.setUpdateTime(df.format(series.getUpdateTime()));
        epgUnifiedSearch.setCreateTime(Long.parseLong(df.format(series.getUpdateTime())));
        epgUnifiedSearch.setReleaseYear(0);
        String releaseYear = series.getReleaseYear();
        if (!"".equals(releaseYear) && isInteger(releaseYear)) {
            epgUnifiedSearch.setReleaseYear(Integer.parseInt(releaseYear));
        }
        epgUnifiedSearch.setLicensingWindowEnd(series.getLicensingWindowEnd());
        epgUnifiedSearch.setOriginalCountry(series.getOriginalCountry());
        epgUnifiedSearch.setGener(series.getGenre());
        epgUnifiedSearch.setTags(series.getTags());
        epgUnifiedSearch.setKeyword(series.getSearchName().toUpperCase());
        epgUnifiedSearch.setKeywordScore(stringToAscii(epgUnifiedSearch.getKeyword()));
        MyBatisModelSetup setup = new MyBatisModelSetup();
        setup = new MyBatisModelSetup();
        setup.addParameter("seriesCode", code);
        List<Movie> movieList = iMovieService.selectBySeries(setup);
        if (!movieList.isEmpty()) {
            if (null != movieList.get(0).getDuration() && isInteger(movieList.get(0).getDuration())) {
                if (movieList.get(0).getDuration().length() == 6 || movieList.get(0).getDuration().length() == 8) {
                    String duration = movieList.get(0).getDuration();
                    int dur = 3600 * Integer.parseInt(duration.substring(0, 2)) + 60 * Integer.parseInt(duration.substring(2, 4)) + Integer.parseInt(duration.substring(4, 6));
                    epgUnifiedSearch.setDuring(dur);
                }
            }
            epgUnifiedSearch.setType5(1);
        }
        if (name.length() <= 16) {
            epgUnifiedSearch.setNameLength(17 - name.length());
        } else {
            epgUnifiedSearch.setNameLength(1);
        }
        List<Map<String, String>> mapList = iImageMediaMappingService.getImgListMap(series.getId());
        epgUnifiedSearch.setPicture(this.getMapList(mapList, "img_type", "images"));
        epgUnifiedSearch.setContentScore(0);
        String contentScore = series.getContentScore();
        if (!"".equals(contentScore) && isInteger(contentScore)) {
            epgUnifiedSearch.setContentScore(Integer.parseInt(contentScore));
        }
        epgUnifiedSearch.setPv(0);
        String playCount = series.getUseTimes();
        if (!"".equals(playCount) && isInteger(playCount)) {
            epgUnifiedSearch.setPv(Integer.parseInt(playCount));
        }

        epgUnifiedSearch.setType1(2);
        Pattern p = Pattern.compile("^[0-9].*");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            epgUnifiedSearch.setType1(1);
        }
        // 是否特殊字符
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
                    epgUnifiedSearch.setType2(1);
                    break;
                }
            }
        }
        // 是否绑定服务
        epgUnifiedSearch.setType3(2);
        setup = new MyBatisModelSetup();
        setup.addParameter("mediaCode", code);
        List<MediaServiceMapping> mediaServiceMappingList = iMediaServiceMappingService.getAll(setup);
        if (!mediaServiceMappingList.isEmpty()) {
            epgUnifiedSearch.setType3(1);
        }
        // 是否绑定栏目
        epgUnifiedSearch.setType4(2);
        List<CategoryVodMapping> categoryVodMappingList = iCategoryVodMappingService.getByMediaCode(code);
        if (categoryVodMappingList != null && categoryVodMappingList.size() > 0) {
            epgUnifiedSearch.setType4(1);
        }
        epgUnifiedSearch.setType6(2);
        epgUnifiedSearch.setType7(2);
        epgUnifiedSearch.setType8(2);
        epgUnifiedSearch.setType9(2);
        epgUnifiedSearch.setLanguage(series.getLanguage());
        epgUnifiedSearch.setActorDisplay(series.getActorDisplay());
        epgUnifiedSearch.setDirectorDisplay(series.getDirectorDisplay());
        // 差异
        epgUnifiedSearch.setSeriesFlag(1);
        epgUnifiedSearch.setSeriesChild(2);
        String sequence = iSeriesProgramService.getCurSerial(code);
        if (null != sequence && !"".equals(sequence)) {
            epgUnifiedSearch.setSeriesChild(1);
        }
        // 检索栏目判断
        epgUnifiedSearch.setRetrievalFlag(0);
        String retrievalCategory = "100990000000000012284039";
        List<CategoryVodMapping> categoryVodMappingList1 = iCategoryVodMappingService.getByPCategoryCodeAndMediaCode(retrievalCategory, code);
        if (categoryVodMappingList1 != null && categoryVodMappingList1.size() > 0) {
            epgUnifiedSearch.setRetrievalFlag(1);
        }
        return epgUnifiedSearch;
    }

    public static boolean isInteger(String str) {
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

    private int stringToAscii(String value) {
        int total = 0;
        char[] chars = value.toCharArray();
        int length = 16;
        if (chars.length < 16) {
            length = chars.length;
        }
        for (int i = 0; i < length; i++) {
            total = total + (length - 1 - i) * 46 + (int) chars[i];
        }
        return 7537 - total;
    }
}
