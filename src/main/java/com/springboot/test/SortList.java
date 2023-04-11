package com.springboot.test;

import java.text.SimpleDateFormat;
import java.util.*;

public class SortList {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("adId", "1");
        map1.put("startTime", "20191030000000");
        map1.put("strategyLevel", 2);
        list.add(map1);
        Map map2 = new HashMap();
        map2.put("adId", "2");
        map2.put("startTime", "20191031000000");
        map2.put("strategyLevel", 4);
        list.add(map2);
        Map map3 = new HashMap();
        map3.put("adId", "3");
        map3.put("startTime", "20191031000000");
        map3.put("strategyLevel", 1);
        list.add(map3);
        Map map4 = new HashMap();
        map4.put("adId", "4");
        map4.put("startTime", "20191030000000");
        map4.put("strategyLevel", 4);
        list.add(map4);
        Map map5 = new HashMap();
        map5.put("adId", "5");
        map5.put("startTime", "20191030000000");
        map5.put("strategyLevel", 3);
        list.add(map5);

        Collections.sort(list, new Comparator<Map>() {
            public int compare(Map map1, Map map2) {
                int level1 = Integer.parseInt(map1.get("strategyLevel").toString());
                int level2 = Integer.parseInt(map2.get("strategyLevel").toString());
                Date time1 = parserStr2Date(map1.get("startTime").toString(), "yyyyMMddHHmmss");
                Date time2 = parserStr2Date(map2.get("startTime").toString(), "yyyyMMddHHmmss");
                if (level1 < level2) {
                    return 1;
                } else if (level1 > level2) {
                    return -1;
                } else {
                    if (time1.compareTo(time2) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for (Map<String, Object> map : list) {
            System.out.println(map.get("adId"));
        }
    }

    public static Date parserStr2Date(String dateString, String formatString){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(formatString);
            return sdf.parse(dateString);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
