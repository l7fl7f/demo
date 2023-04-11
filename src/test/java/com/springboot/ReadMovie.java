package com.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.c2.entity.*;
import com.springboot.c2.service.*;
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
public class ReadMovie {
    @Autowired
    private IMovieService iMovieService;

    @Test
    public void txtTest() {
        String fileName = "C:\\Users\\lqf\\Desktop\\movie.txt";
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
            File wfile = new File("C:\\Users\\lqf\\Desktop\\mongo_movie.txt");
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
                String jsonStr = this.publishMovie(tempString, "REGIST");
                if (!"".equals(jsonStr)) {
                    jsonStr = "db.movie.save("+jsonStr+");\n";
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

    public String publishMovie(String code, String action) {
        String jsonStr = "";
        try {
            EpgMovie epgMovie = null;
            if ("DELETE".equals(action)) {
                epgMovie = new EpgMovie();
                epgMovie.setId(code);
            } else {
                MyBatisModelSetup setup = new MyBatisModelSetup();
                setup.addParameter("code", code);
                List<Movie> movieList = iMovieService.getAll(setup);
                if (null != movieList && movieList.size() > 0) {
                    epgMovie = this.getEpgMovieByMovie(movieList.get(0));
                    if (null != epgMovie && !"".equals(epgMovie.getId())) {
                        jsonStr = JSONObject.toJSONString(epgMovie);
                        jsonStr = jsonStr.replace("\"id\"", "\"_id\"");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public EpgMovie getEpgMovieByMovie(Movie movie) {
        EpgMovie epgMovie = new EpgMovie();
        epgMovie.setId(movie.getId());
        epgMovie.setCode(movie.getCode());
        epgMovie.setAudioFormat(movie.getAudioFormat());
        epgMovie.setAudioType(movie.getAudioType());
        epgMovie.setBitrateType(movie.getBitrateType());
        epgMovie.setClosedCaptioning(movie.getClosedCaptioning());
        epgMovie.setDestDrmType(movie.getDestDrmType());
        epgMovie.setDomainType(movie.getDomainType());
        epgMovie.setDuration(movie.getDuration());
        epgMovie.setElementType(movie.getElementType());
        epgMovie.setErrorMsg(movie.getErrorMsg());
        epgMovie.setFileSize(movie.getFileSize());
        epgMovie.setFileUrl(movie.getFileUrl());
        epgMovie.setName(movie.getName());
        epgMovie.setNextTime(movie.getNextTime());
        epgMovie.setOcsUrl(movie.getOcsUrl());
        epgMovie.setProvider(movie.getProvider());
        epgMovie.setResolution(movie.getResolution());
        epgMovie.setScreenFormat(movie.getScreenFormat());
        epgMovie.setServiceType(movie.getServiceType());
        epgMovie.setSourceDrmType(movie.getSourceDrmType());
        epgMovie.setState(movie.getState());
        epgMovie.setSystemLayer(movie.getSystemLayer());
        epgMovie.setType(movie.getType());
        epgMovie.setVideoProfile(movie.getVideoProfile());
        epgMovie.setVideoType(movie.getVideoType());
        epgMovie.setBizDomain(movie.getBizDomain());
        epgMovie.setMessageId(movie.getMessageId());
        epgMovie.setStorePath(movie.getStorePath());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        epgMovie.setCreateTime(formatter.format(movie.getCreateTime()));
        epgMovie.setUpdateTime(formatter.format(movie.getUpdateTime()));
        epgMovie.setMovieId(movie.getId());
        epgMovie.setMovieCode(movie.getCode());
        if (!"".equals(movie.getFileUrl()) && movie.getFileUrl().indexOf(".") > -1) {
            String ftpUrl = movie.getFileUrl();
            ftpUrl = ftpUrl.substring(ftpUrl.lastIndexOf(".") + 1);
            if (ftpUrl.length() <= 4) {
                epgMovie.setVideoFormat(movie.getSystemLayer() + "." + ftpUrl);
            } else {
                epgMovie.setVideoFormat(movie.getSystemLayer() + ".");
            }
        } else if (!"".equals(movie.getStorePath()) && movie.getStorePath().indexOf(".") > -1) {
            String ftpUrl = movie.getStorePath();
            ftpUrl = ftpUrl.substring(ftpUrl.lastIndexOf(".") + 1);
            if (ftpUrl.length() <= 4) {
                epgMovie.setVideoFormat(movie.getSystemLayer() + "." + ftpUrl);
            } else {
                epgMovie.setVideoFormat(movie.getSystemLayer() + ".");
            }
        } else if (!"".equals(movie.getSystemLayer())) {
            epgMovie.setVideoFormat(movie.getSystemLayer() + ".");
        } else if (!"".equals(movie.getBizDomain())) {
            if ("2".equals(movie.getBizDomain())) {
                epgMovie.setVideoFormat(".mp4");
            } else {
                epgMovie.setVideoFormat(".ts");
            }
        } else {
            epgMovie.setVideoFormat("1.ts");
        }
        return epgMovie;
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
