package com.springboot.c2.dao;

import com.springboot.c2.entity.ImageMediaMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: ImageMediaMappingDAO
 * @Project: 
 * @date: 2018-08-29 11:44
 * @author: 
 * @Description: ImageMediaMappingDAO
 */
@Mapper
public interface ImageMediaMappingDAO extends IEntityDao<ImageMediaMapping> {
    /**
     * 根据 图片id 删除图片媒资对应关系
     * @param id
     */
    void deleteByImagesId(String id);

    /**
     * 根据 mediaId 查询图片媒资对应关系
     * @param mediaId
     * @return
     */
    List<ImageMediaMapping> findByMediaId(String mediaId);


    /***
     * 根据媒资ID查询图片map
     * @param mediaId
     * @return
     */
    public List<Map<String,String>> getImgListMap(@Param("mediaId") String mediaId);

    /**
     * 根据图片code查询拍寻信息
     *
     * @param imgCode
     * @return
     */
    public String selectSequence(@Param("imgCode") String imgCode);

}