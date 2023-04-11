package com.springboot.c2.service;

import com.springboot.c2.entity.MediaCastMapping;
import com.springboot.c2.utils.IBaseEntityService;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: IMediaCastMappingService
 * @Project:
 * @date: 2018-08-30 17:14
 * @author:
 * @Description: IMediaCastMappingService
 */
public interface IMediaCastMappingService extends IBaseEntityService {


    /***
     * 根据媒资ID查询演员map
     * @param mediaId
     * @return
     */
    List<Map<String, String>> getCastListMap(String mediaId);


}