package com.springboot.c2.dao;

import com.springboot.c2.entity.CpspInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 *
 * @Title: CpspInfoDAO
 * @Project: smp-core
 * @date: 2018-07-27 16:41
 * @author: yangbo
 * @Description: CpspInfoDAO
 */
@Mapper
public interface CpspInfoDAO extends IEntityDao<CpspInfo> {
    /**
     * 更新状态
     *
     * @param params 查询条件参数（id、status）
     */
    void updateStatus(Map<String, Object> params);

    /**
     * 查找对应的状态
     *
     * @param status 状态名称
     * @return List<CpspInfo>
     */
    List<CpspInfo> findByStatus(String status);

    /**
     * 根据cpId、name查询（条件：or）
     *
     * @param params cpId、name
     * @return List<CpspInfo>
     */
    List<CpspInfo> fingByCpIdOrName(Map<String, Object> params);

    /**
     * 根据cpId查询信息
     *
     * @param cpIds
     * @return
     */
    List<CpspInfo> selectByCpIds(Object[] cpIds);
}