package com.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.c2.entity.CpspInfo;
import com.springboot.c2.entity.EpgMediaVod;
import com.springboot.c2.entity.MediaServiceMapping;
import com.springboot.c2.entity.Program;
import com.springboot.c2.service.*;
import com.springboot.c2.utils.MyBatisModelSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class ReadProgram {
    @Autowired
    private IProgramService iProgramService;
    @Autowired
    private IMediaServiceMappingService iMediaServiceMappingService;
    @Autowired
    private ICpspInfoService cpspInfoService;
    @Autowired
    private ICategoryVodMappingService iCategoryVodMappingService;
    @Autowired
    private IImageMediaMappingService iImageMediaMappingService;
    @Autowired
    private IMediaCastMappingService iMediaCastMappingService;

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
            File wfile = new File("C:\\Users\\lqf\\Desktop\\mongo_program.txt");
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
                String jsonStr = this.publishProgram(tempString, "REGIST");
                if (!"".equals(jsonStr)) {
                    jsonStr = "db.media.save("+jsonStr+");\n";
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

    public String publishProgram(String code, String action) {
        String jsonStr = "";
        try {
            EpgMediaVod epgMediaVod = null;
            if ("DELETE".equals(action)) {
                epgMediaVod = new EpgMediaVod();
                epgMediaVod.setId(code);
            } else {
                MyBatisModelSetup setup = new MyBatisModelSetup();
                setup.addParameter("code", code);
                List<Program> programList = iProgramService.getAll(setup);
                if (null != programList && programList.size() > 0) {
                    epgMediaVod = this.getEpgMediaVodByProgram(programList.get(0));
                    if (null != epgMediaVod && !"".equals(epgMediaVod.getId())) {
                        jsonStr = JSONObject.toJSONString(epgMediaVod);
                        jsonStr = jsonStr.replace("\"id\"", "\"_id\"");
                        jsonStr = jsonStr.replace("\"tags\"", "\"Tags\"");
                        jsonStr = jsonStr.replace("\"vODID\"", "\"VODID\"");
                        jsonStr = jsonStr.replace("\"extendInfoList\"", "\"ExtendInfoList\"");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public EpgMediaVod getEpgMediaVodByProgram(Program program) {
        EpgMediaVod epgMediaVod = new EpgMediaVod();
        epgMediaVod.setId(program.getCode());
        epgMediaVod.setVODID(0);
        String metaId = "0";
        if ("1".equals(program.getSeriesFlag())) {
            metaId = "99";
        }
        epgMediaVod.setMetaId(metaId);
        epgMediaVod.setType(program.getType());
        epgMediaVod.setMediaId(program.getId());
        epgMediaVod.setMediaCode(program.getCode());
        epgMediaVod.setTitle(program.getName());
        epgMediaVod.setScreenCode(program.getrMediaCode());
        epgMediaVod.setOrderNumber(program.getOrderNumber());
        epgMediaVod.setActorDisplay(program.getActorDisplay());
        epgMediaVod.setWriterDisplay(program.getWriterDisplay());
        epgMediaVod.setDescription(program.getDescription());
        epgMediaVod.setDirectorDisplay(program.getDirectorDisplay());
        epgMediaVod.setReserve1(program.getReserve1());
        epgMediaVod.setReserve2(program.getReserve2());
        epgMediaVod.setReserve3(program.getReserve3());
        epgMediaVod.setReserve4(program.getReserve4());
        epgMediaVod.setReserve5(program.getReserve5());

        //服务信息
        MyBatisModelSetup setup = new MyBatisModelSetup();
        setup.addParameter("mediaId", program.getId());
        List<MediaServiceMapping> mediaServiceMappingList = iMediaServiceMappingService.getAll(setup);
        String[] serviceArrar = new String[mediaServiceMappingList.size()];
        if (mediaServiceMappingList != null && mediaServiceMappingList.size() > 0) {
            for (int i = 0; i < mediaServiceMappingList.size(); i++) {
                MediaServiceMapping mediaServiceMapping = mediaServiceMappingList.get(i);
                serviceArrar[i] = mediaServiceMapping.getServiceId();
            }
        }
        epgMediaVod.setServiceId(serviceArrar);

        epgMediaVod.setFatherVodId(-1);
        epgMediaVod.setIsSitcom(Integer.valueOf(epgMediaVod.getMetaId() == "1" ? "1" : "0"));
        epgMediaVod.setPrice(program.getPrice() + "");
        epgMediaVod.setSearchCode(program.getSearchName() != null ? program.getSearchName().toUpperCase() : "");
        epgMediaVod.setYear(program.getReleaseYear());
        epgMediaVod.setReleaseTime(program.getOrgAirDate());
        if (program.getOrgAirDate() != null && !"".equals(program.getOrgAirDate()) && program.getOrgAirDate().length() >= 8) {
            try {
                epgMediaVod.setShowTime(Long.valueOf(String.valueOf(new SimpleDateFormat("yyyyMMdd").parse(program.getOrgAirDate()).getTime() / 1000) + "000"));//上映时间
            } catch (Exception e) {
                epgMediaVod.setShowTime(0);
            }
        } else if (program.getOrgAirDate() != null && !"".equals(program.getOrgAirDate()) && program.getOrgAirDate().length() >= 4) {
            try {
                epgMediaVod.setShowTime(Long.valueOf(program.getOrgAirDate()));
            } catch (Exception e) {
                epgMediaVod.setShowTime(0);
            }
        } else {
            epgMediaVod.setShowTime(0);
        }
        epgMediaVod.setLicensingWindowStart(program.getLicensingWindowStart());
        epgMediaVod.setLicensingWindowEnd(program.getLicensingWindowEnd());
        epgMediaVod.setUpEpgTime(System.currentTimeMillis());
        epgMediaVod.setContentType("".equals(program.getSourceType()) ? 0 : Integer.valueOf(program.getSourceType()));
        epgMediaVod.setViewPoint(program.getViewPoint());
        epgMediaVod.setKeyWords(program.getKeywords());
        epgMediaVod.setTags(program.getTags());
        epgMediaVod.setCpId(program.getProvider());
        List<CpspInfo> cpspInfoList = cpspInfoService.fingByCpIdOrName(program.getProvider(), "");
        if (cpspInfoList != null && cpspInfoList.size() > 0) {
            epgMediaVod.setCpName(cpspInfoList.get(0).getName());
        } else {
            epgMediaVod.setCpName("");
        }
        epgMediaVod.setOriginalName(program.getOriginalName());
        epgMediaVod.setSortName(program.getSortName());
        epgMediaVod.setGenre(program.getGenre());
        epgMediaVod.setOriginalCountry(program.getOriginalCountry());
        epgMediaVod.setLanguage(program.getLanguage());
        epgMediaVod.setDefinitionFlag("".equals(program.getDefinitionFlag()) ? 0 : Integer.valueOf(program.getDefinitionFlag()));
        epgMediaVod.setAreaIds(new String[]{});
        epgMediaVod.setScore(program.getContentScore());
        epgMediaVod.setAwards(program.getAwards());
        epgMediaVod.setDistributor(program.getDistributor());
        epgMediaVod.setSubstitleLang(program.getSubstitleLang());
        epgMediaVod.setTotalSerial(1);
        // 单集当前集数置为1
        epgMediaVod.setCurSerial(1);
        epgMediaVod.setDisplayAsNew("".equals(program.getDisplayAsNew()) ? 0 : Integer.parseInt(program.getDisplayAsNew()));
        epgMediaVod.setDisplayAsLastChance("".equals(program.getDisplayAsLastChance()) ? 0 : Integer.parseInt(program.getDisplayAsLastChance()));
        epgMediaVod.setMacrovision("".equals(program.getMacroVision()) ? 0 : Integer.valueOf(program.getMacroVision()));
        epgMediaVod.setPlayCount("".equals(program.getUseTimes()) ? 0 : Integer.parseInt(program.getUseTimes()));
        epgMediaVod.setExtendInfoList(new ArrayList<>());
        List<Map<String, String>> categoryList = iCategoryVodMappingService.getCategoryIdName(program.getId());
        List<Map<String, String>> newMapList = new ArrayList<>();
        for (Map<String, String> m : categoryList) {
            Map<String, String> tmp = new HashMap();
            tmp.put("categoryId", m.get("categoryId"));
            tmp.put("categoryName", m.get("categoryName"));
            newMapList.add(tmp);
        }
        epgMediaVod.setCategoryIds(newMapList);
        //图片
        List<Map<String, String>> imageList = iImageMediaMappingService.getImgListMap(program.getId());
        epgMediaVod.setImages(this.getMapList(imageList, "img_type", "images"));
        //演员信息
        List<Map<String, String>> castList = iMediaCastMappingService.getCastListMap(program.getId());
        epgMediaVod.setCast(this.getMapList(castList, "cast_role", "casts"));
        epgMediaVod.setpMediaId("");
        epgMediaVod.setpMediaCode("");
        epgMediaVod.setCreateTime(Long.valueOf(String.valueOf((program.getCreateTime()).getTime() / 1000) + "000"));
        epgMediaVod.setCategoryPids(new ArrayList<>());
        //检索类型数据
        epgMediaVod.setGenreKey(new ArrayList<>());
        //检索产地数据
        epgMediaVod.setOriginalCountryKey(new ArrayList<>());
        epgMediaVod.setBizDomain(program.getBizDomain());
        return epgMediaVod;
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
