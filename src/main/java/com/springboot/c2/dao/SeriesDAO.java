package com.springboot.c2.dao;

import com.springboot.c2.entity.Series;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeriesDAO {

    void insert(Series series);

    void updateByCode(Series series);

    void delete(String code);

    List<Series> selectAll(ModelSetup setup);
}
