package com.springboot.c2.service;

import com.springboot.c2.dao.CpspInfoDAO;
import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.entity.CpspInfo;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018IPTV
 * 
 * @Title: CpspInfoService
 * @Project: smp-core
 * @date: 2018-07-27 16:41
 * @author: yangbo
 * @Description: CpspInfoService
 */
@Service
public class CpspInfoService extends BaseEntityService<CpspInfo> implements ICpspInfoService {

    @Autowired
    private CpspInfoDAO cpspInfoDAO;

    @Override
    protected IEntityDao<CpspInfo> getDao() {
        return cpspInfoDAO;
    }

    @Override
    public List<CpspInfo> fingByCpIdOrName(String cpId, String name) {
        Map<String,Object> params = new HashMap<>();
        params.put("cpId", cpId);
        params.put("name", name);
        return cpspInfoDAO.fingByCpIdOrName(params);
    }
}