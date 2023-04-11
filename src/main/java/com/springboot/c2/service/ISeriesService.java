package com.springboot.c2.service;

import com.springboot.c2.entity.Series;
import com.springboot.c2.utils.ModelSetup;

import java.util.List;

public interface ISeriesService {

    void insert(Series series);

    void update(Series series);

    void delete(String code);

    List getAll(ModelSetup setup);

}
