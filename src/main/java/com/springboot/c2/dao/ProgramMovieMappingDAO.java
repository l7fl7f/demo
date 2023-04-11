package com.springboot.c2.dao;

import com.springboot.c2.entity.ProgramMovieMapping;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProgramMovieMappingDAO {

    void insert(ProgramMovieMapping programMovieMapping);

    void update(ProgramMovieMapping programMovieMapping);

    void delete(Map<String, String> params);

    List<ProgramMovieMapping> selectAll(ModelSetup setup);
}
