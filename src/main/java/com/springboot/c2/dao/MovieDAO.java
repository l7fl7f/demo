package com.springboot.c2.dao;

import com.springboot.c2.entity.Movie;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieDAO {

    void insert(Movie movie);

    void updateByCode(Movie movie);

    void delete(String code);

    List<Movie> selectAll(ModelSetup setup);

    List<Movie> selectByProgram(ModelSetup setup);

    List<Movie> selectBySeries(ModelSetup setup);
}
