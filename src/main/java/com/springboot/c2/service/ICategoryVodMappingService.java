package com.springboot.c2.service;

import com.springboot.c2.entity.CategoryVodMapping;
import com.springboot.c2.utils.IBaseEntityService;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: ICategoryVodMappingService
 * @Project:
 * @date: 2018-08-28 10:41
 * @author:
 * @Description: ICategoryVodMappingService
 */
public interface ICategoryVodMappingService extends IBaseEntityService {

    /***
     * 根据媒资ID查询分类ID和名称
     * @param mediaId
     * @return
     */
    List<Map<String, String>> getCategoryIdName(String mediaId);

    List<CategoryVodMapping> getByMediaCode(String mediaCode);

    List<CategoryVodMapping> getByPCategoryCodeAndMediaCode(String pCategoryCode, String mediaCode);

}