package com.springboot.c2.utils;

import java.util.Map;

public interface ModelSetup {
     public void setup(Map<String, Object> params);

     public void addParameter(String name, Object value);

     public int getPageNo();

     public int getPageSize();
}
