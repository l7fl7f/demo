package com.springboot.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.c2.entity.EpgMediaVod;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ForTest {
    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {
//        int i =0;
//        for(foo('A');foo('B')&&(i<2);foo('C'))
//        {
//            i++;
//            foo('D');
//        }

//        System.out.println("a" + null);
//        Calendar rightNow = Calendar.getInstance();
//        System.out.println(rightNow.get(Calendar.DAY_OF_MONTH));
//        System.out.println("PV123".substring(2));

//        List<String> epgMediaVodList = new ArrayList<>();
//        Map map = new HashMap();
//        map.put("mediaList", epgMediaVodList);
//        String data = "";
//        if (map instanceof Map) {
//            data = JSONObject.toJSONString(map);
//        } else if (map instanceof List) {
//            data = JSONArray.toJSONString(map);
//        } else {
//            data = map.toString();
//        }
//        System.out.println(data);

        Map<String, String> sessionMap = new ConcurrentHashMap<>();
        System.out.println(sessionMap.values().size());
        System.out.println(sessionMap.size());
    }
}
