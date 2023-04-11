package com.springboot.c2.service;

import com.springboot.c2.entity.CpPlate;
import com.springboot.c2.utils.IBaseEntityService;

import java.util.List;

public interface ICpPlateService extends IBaseEntityService {
    List<CpPlate> selectByCpId(String cpId);
}