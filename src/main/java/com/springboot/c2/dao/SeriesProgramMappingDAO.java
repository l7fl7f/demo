package com.springboot.c2.dao;

import com.springboot.c2.entity.SeriesProgramMapping;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SeriesProgramMappingDAO {

    void insert(SeriesProgramMapping seriesProgramMapping);

    void update(SeriesProgramMapping seriesProgramMapping);

    void delete(Map<String, String> params);

    List<SeriesProgramMapping> selectAll(ModelSetup setup);

    String getCurSerial(String seriesCode);
}
