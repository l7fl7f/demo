package com.springboot.c2.service;

import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.dao.ImageMediaMappingDAO;
import com.springboot.c2.entity.ImageMediaMapping;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: ImageMediaMappingService
 * @Project:
 * @date: 2018-08-29 11:44
 * @author:
 * @Description: ImageMediaMappingService
 */
@Service
public class ImageMediaMappingService extends BaseEntityService<ImageMediaMapping> implements IImageMediaMappingService {
    @Autowired
    private ImageMediaMappingDAO imageMediaMappingDAO;


    @Override
    protected IEntityDao<ImageMediaMapping> getDao() {
        return imageMediaMappingDAO;
    }


    @Override
    public List<Map<String, String>> getImgListMap(String mediaId) {
        return imageMediaMappingDAO.getImgListMap(mediaId);
    }

}