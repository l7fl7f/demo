package com.springboot.c2.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * ModelSetup的默认实现，不带任何参数
 */
public class DefaultModelSetup implements ModelSetup {
     private Map<String,Object> q = new HashMap<>();

     public Map<String, Object> getQ() {
          return q;
     }

     public void setQ(Map<String, Object> q) {
          this.q = q;
     }

     public void addParameter(String name,Object value) {
     }

     public void setup(Map<String,Object> params){
     }

     public int getPageNo() {
          return 1;
     }

     public int getPageSize() {
          return Page.DEFAULT_PAGE_SIZE;
     }
}
