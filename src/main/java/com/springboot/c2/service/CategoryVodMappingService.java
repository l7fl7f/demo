package com.springboot.c2.service;

import com.springboot.c2.dao.CategoryVodMappingDAO;
import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.entity.CategoryVodMapping;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: CategoryVodMappingService
 * @Project:
 * @date: 2018-08-28 10:41
 * @author:
 * @Description: CategoryVodMappingService
 */
@Service
public class CategoryVodMappingService extends BaseEntityService<CategoryVodMapping> implements ICategoryVodMappingService {
    @Autowired
    private CategoryVodMappingDAO categoryVodMappingDAO;

    @Override
    protected IEntityDao<CategoryVodMapping> getDao() {
        return categoryVodMappingDAO;
    }

    @Override
    public List<Map<String, String>> getCategoryIdName(String mediaId) {
        List<Map<String, String>> list = categoryVodMappingDAO.getCategoryIdName(mediaId);
        return list;
    }

    @Override
    public List<CategoryVodMapping> getByMediaCode(String mediaCode) {
        return categoryVodMappingDAO.selectByMediaCode(mediaCode);
    }

    @Override
    public List<CategoryVodMapping> getByPCategoryCodeAndMediaCode(String pCategoryCode, String mediaCode) {
        return categoryVodMappingDAO.getByPCategoryCodeAndMediaCode(pCategoryCode, mediaCode);
    }

}