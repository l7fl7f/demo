package com.springboot.c2.service;

import com.springboot.c2.entity.CpspInfo;
import com.springboot.c2.utils.IBaseEntityService;

import java.util.List;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: ICpspInfoService
 * @Project: smp-core
 * @date: 2018-07-27 16:41
 * @author: yangbo
 * @Description: ICpspInfoService
 */
public interface ICpspInfoService extends IBaseEntityService {

    /**
     * 根据cpId、name查询（条件：or）
     * @param cpId cp/sp服务商id
     * @param name cp/sp名称
     * @return List<CpspInfo>
     */
    List<CpspInfo> fingByCpIdOrName(String cpId, String name);

}