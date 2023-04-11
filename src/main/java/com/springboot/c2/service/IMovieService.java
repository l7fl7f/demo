package com.springboot.c2.service;

import com.springboot.c2.entity.Movie;
import com.springboot.c2.utils.ModelSetup;

import java.util.List;

public interface IMovieService {

    void insert(Movie movie);

    void update(Movie movie);

    void delete(String code);

    List getAll(ModelSetup setup);

    List selectByProgram(ModelSetup setup);

    List selectBySeries(ModelSetup setup);
}
