package com.springboot.c2.service;

import com.springboot.c2.entity.Program;
import com.springboot.c2.utils.ModelSetup;

import java.util.List;

public interface IProgramService {

    void insert(Program program);

    void update(Program program);

    void delete(String code);

    List getAll(ModelSetup setup);
}
