package com.springboot.c2.dao;

import com.springboot.c2.entity.CpPlate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CpPlateDAO extends IEntityDao<CpPlate> {
    List<CpPlate> selectByCpId(String cpId);
}