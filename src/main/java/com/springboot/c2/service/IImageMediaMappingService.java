package com.springboot.c2.service;

import com.springboot.c2.utils.IBaseEntityService;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: IImageMediaMappingService
 * @Project: 
 * @date: 2018-08-29 11:44
 * @author: 
 * @Description: IImageMediaMappingService
 */
public interface IImageMediaMappingService extends IBaseEntityService {

    /***
     * 根据媒资ID查询图片map
     * @param mediaId
     * @return
     */
    List<Map<String,String>> getImgListMap(String mediaId);


}