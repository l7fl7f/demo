package com.springboot.c2.service;

import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.dao.MediaCastMappingDAO;
import com.springboot.c2.entity.MediaCastMapping;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: MediaCastMappingService
 * @Project:
 * @date: 2018-08-30 17:36
 * @author:
 * @Description: MediaCastMappingService
 */
@Service
public class MediaCastMappingService extends BaseEntityService<MediaCastMapping> implements IMediaCastMappingService {
    @Autowired
    private MediaCastMappingDAO mediaCastMappingDAO;


    @Override
    protected IEntityDao<MediaCastMapping> getDao() {
        return mediaCastMappingDAO;
    }



    @Override
    public List<Map<String, String>> getCastListMap(String mediaId) {
        return mediaCastMappingDAO.getCastListMap(mediaId);
    }



}