package com.springboot.c2.service;

import com.springboot.c2.dao.CpPlateDAO;
import com.springboot.c2.dao.IEntityDao;
import com.springboot.c2.entity.CpPlate;
import com.springboot.c2.utils.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cpPlateService")
public class CpPlateService extends BaseEntityService<CpPlate> implements ICpPlateService {


    @Autowired
    private CpPlateDAO cpPlateDAO;

    @Override
    protected IEntityDao<CpPlate> getDao() {
        return cpPlateDAO;
    }

    @Override
    public List<CpPlate> selectByCpId(String cpId) {
        return cpPlateDAO.selectByCpId(cpId);
    }
}