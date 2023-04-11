package com.springboot.c2.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyBatisModelSetup implements ModelSetup {
     private Map<String,Object> q = new HashMap<>();

     public Map<String, Object> getQ() {
          return q;
     }

     public void setQ(Map<String, Object> q) {
          this.q = q;
     }

     public void addParameter(String name,Object value) {
          this.q.put(name,value);
     }

     public void setup(Map<String,Object> params){
          Set<String> keys = params.keySet();
          for (String key : keys) {
               Object value = params.get(key);
               if (value!=null) {
                    q.put(key, value);
               }
          }
     }

     public int getPageNo() {
          int startIndex = Integer.parseInt(q.get("page.startIndex").toString());
          int pageSize = NumberUtils.toInt(String.valueOf(q.get("page.pageSize")), Page.DEFAULT_PAGE_SIZE);
          String pageNo = String.valueOf(startIndex/ pageSize + 1);
          return  NumberUtils.toInt(pageNo,1);
     }

     public int getPageSize() {
          String pageSize = String.valueOf(q.get("page.pageSize")) ;
          return NumberUtils.toInt(pageSize, Page.DEFAULT_PAGE_SIZE);
     }


     public static MyBatisModelSetup buildSetUp(Map<String,Object> pams){
          MyBatisModelSetup setup = new MyBatisModelSetup();
          setup.setup(pams);
          Map<String,Object> q = setup.getQ();
          int startIndex = Integer.parseInt(pams.get("page.startIndex").toString());
          int pageSize = Integer.valueOf(pams.get("page.pageSize").toString());
          int pageNo = startIndex/ Page.DEFAULT_PAGE_SIZE+1;
          q.put("pageSize",String.valueOf(pageSize));
          q.put("pageNo",String.valueOf(pageNo));
          return setup;
     }
}
