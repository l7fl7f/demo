package com.springboot.c2.service;

import com.springboot.c2.entity.ProgramMovieMapping;
import com.springboot.c2.utils.ModelSetup;

import java.util.List;

public interface IProgramMovieService {

    void insert(ProgramMovieMapping programMovieMapping);

    void update(ProgramMovieMapping programMovieMapping);

    void delete(String movieCode, String programCode);

    List getAll(ModelSetup setup);
}
