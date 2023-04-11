package com.springboot.c2.service;

import com.springboot.c2.entity.SeriesProgramMapping;
import com.springboot.c2.utils.ModelSetup;

import java.util.List;

public interface ISeriesProgramService {

    void insert(SeriesProgramMapping seriesProgramMapping);

    void update(SeriesProgramMapping seriesProgramMapping);

    void delete(String episodeCode, String seriesCode);

    List getAll(ModelSetup setup);

    String getCurSerial(String seriesCode);
}
