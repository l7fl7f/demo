package com.springboot.c2.dao;

import com.springboot.c2.entity.MediaCastMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: MediaCastMappingDAO
 * @Project:
 * @date: 2018-08-30 17:36
 * @author:
 * @Description: MediaCastMappingDAO
 */
@Mapper
public interface MediaCastMappingDAO extends IEntityDao<MediaCastMapping> {
    /**
     * 根据 roleId 查询
     *
     * @param params roleId、mediaId
     * @return
     */
    MediaCastMapping findByRoleIdMediaId(Map<String, String> params);

    /**
     * 根据 roleId数组、mediaId 删除记录
     *
     * @param roleIdArray
     * @param mediaId
     */
    void deleteByRoleIds(@Param("roleIdArray") String[] roleIdArray, @Param("mediaId") String mediaId);

    /**
     * 根据 mediaId 删除 mediaCastMapping 记录
     *
     * @param mediaId
     */
    void deleteByMediaId(String mediaId);

    /***
     * 根据媒资ID查询演员map
     * @param mediaId
     * @return
     */
    public List<Map<String, String>> getCastListMap(@Param("mediaId") String mediaId);

    /**
     * 新的roleId替换旧的roleId
     *
     * @param newRoleId
     * @param oldRoleId
     */
    public void updateRoleIdByRoleId(@Param("newRoleId") String newRoleId, @Param("oldRoleId") String oldRoleId);

    /**
     * 新的roleCode替换旧的roleCode
     *
     * @param newRoleCode
     * @param oldRoleCode
     */
    public void updateRoleCodeByRoleCode(@Param("newRoleCode") String newRoleCode, @Param("oldRoleCode") String oldRoleCode);

    /**
     * 根据CastMapping表的id查询MediaCastMapping表id
     *
     * @param ids
     * @return
     */
    public Object[] selectIdsByCastMappingTableIds(Object[] ids);
}