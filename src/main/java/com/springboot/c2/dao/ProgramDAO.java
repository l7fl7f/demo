package com.springboot.c2.dao;

import com.springboot.c2.entity.Program;
import com.springboot.c2.utils.ModelSetup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProgramDAO {

    void insert(Program program);

    void updateByCode(Program program);

    void delete(String code);

    List<Program> selectAll(ModelSetup setup);
}
