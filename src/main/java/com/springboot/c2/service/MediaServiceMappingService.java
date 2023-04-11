package com.springboot.c2.service;

import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.dao.MediaServiceMappingDAO;
import com.springboot.c2.entity.MediaServiceMapping;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: MediaServiceMappingService
 * @Project: 
 * @date: 2018-10-16 09:57
 * @author: 
 * @Description: MediaServiceMappingService
 */
@Service
public class MediaServiceMappingService extends BaseEntityService<MediaServiceMapping> implements IMediaServiceMappingService {
    @Autowired
    private MediaServiceMappingDAO mediaServiceMappingDAO;

    @Override
    protected IEntityDao<MediaServiceMapping> getDao() {
        return mediaServiceMappingDAO;
    }
}