package com.springboot.c2.service;

import com.springboot.c2.dao.ProgramDAO;
import com.springboot.c2.entity.Program;
import com.springboot.c2.utils.ModelSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements IProgramService {
    @Autowired
    private ProgramDAO programDAO;

    @Override
    public void insert(Program program) {
        programDAO.insert(program);
    }

    @Override
    public void update(Program program) {
        programDAO.updateByCode(program);
    }

    @Override
    public void delete(String code) {
        programDAO.delete(code);
    }

    @Override
    public List getAll(ModelSetup setup) {
        return programDAO.selectAll(setup);
    }

}