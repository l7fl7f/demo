package com.springboot.c2.dao;

import com.github.pagehelper.Page;
import com.springboot.c2.entity.CategoryVodMapping;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: CategoryVodMappingDAO
 * @Project:
 * @date: 2018-08-28 10:41
 * @author:
 * @Description: CategoryVodMappingDAO
 */
@Mapper
public interface CategoryVodMappingDAO extends IEntityDao<CategoryVodMapping> {
    /**
     * 根据栏目code和点播code添加
     *
     * @param categoryCode
     * @param codes
     */
    public void insertByCategoryCodeAndVodCodes(@Param("categoryCode") String categoryCode, @Param("codes") String[] codes);

    /**
     * 根据栏目code和点播code删除
     *
     * @param categoryCode
     * @param codes
     */
    public void deleteByCategoryCodeAndVodCodes(@Param("categoryCode") String categoryCode, @Param("codes") String[] codes);

    /**
     * 根据栏目表的自增id删除关联图片
     *
     * @param ids
     */
    public void deleteByCategoryTableIds(Object[] ids);


    /***
     * 根据媒资ID查询分类ID和名称
     * @param mediaId
     * @return
     */
    public List<Map<String, String>> getCategoryIdName(@Param("mediaId") String mediaId);

    /**
     * 根据栏目code查询
     *
     * @param categoryCode
     * @return
     */
    public List<CategoryVodMapping> selectByCategoryCode(@Param("categoryCode") String categoryCode);

    /**
     * 根据栏目code和点播code查询映射关系
     *
     * @param categoryCode
     * @param mediaCode
     * @return
     */
    public CategoryVodMapping selectByCategoryCodeAndMediaCode(@Param("categoryCode") String categoryCode, @Param("mediaCode") String mediaCode);

    List<CategoryVodMapping> getByPCategoryCodeAndMediaCode(@Param("pCategoryCode") String pCategoryCode, @Param("mediaCode") String mediaCode);

    /**
     * 根据点播code查询映射关系
     *
     * @param mediaCode
     * @return
     */
    public List<CategoryVodMapping> selectByMediaCode(String mediaCode);

    /**
     * 根据mediaId删除
     *
     * @param mediaId
     */
    public void deleteByMediaId(@Param("mediaId") String mediaId);

    /**
     * 查询
     * @param setup
     * @return
     */
   public Page lnquery(ModelSetup setup);
}