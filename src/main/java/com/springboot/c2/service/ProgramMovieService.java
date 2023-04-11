package com.springboot.c2.service;

import com.springboot.c2.dao.ProgramMovieMappingDAO;
import com.springboot.c2.entity.ProgramMovieMapping;
import com.springboot.c2.utils.ModelSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProgramMovieService implements IProgramMovieService {
    @Autowired
    private ProgramMovieMappingDAO programMovieMappingDAO;

    @Override
    public void insert(ProgramMovieMapping programMovieMapping) {
        programMovieMappingDAO.insert(programMovieMapping);
    }

    @Override
    public void update(ProgramMovieMapping programMovieMapping) {
        programMovieMappingDAO.update(programMovieMapping);
    }

    @Override
    public void delete(String movieCode, String programCode) {
        Map<String, String> params = new HashMap<>();
        params.put("movieCode", movieCode);
        params.put("programCode", programCode);
        programMovieMappingDAO.delete(params);
    }

    @Override
    public List getAll(ModelSetup setup) {
        return programMovieMappingDAO.selectAll(setup);
    }
}
