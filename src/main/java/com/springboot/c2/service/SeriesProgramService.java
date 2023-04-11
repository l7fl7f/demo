package com.springboot.c2.service;

import com.springboot.c2.dao.SeriesProgramMappingDAO;
import com.springboot.c2.entity.SeriesProgramMapping;
import com.springboot.c2.utils.ModelSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeriesProgramService implements ISeriesProgramService {
    @Autowired
    private SeriesProgramMappingDAO seriesProgramMappingDAO;

    @Override
    public void insert(SeriesProgramMapping seriesProgramMapping) {
        seriesProgramMappingDAO.insert(seriesProgramMapping);
    }

    @Override
    public void update(SeriesProgramMapping seriesProgramMapping) {
        seriesProgramMappingDAO.update(seriesProgramMapping);
    }

    @Override
    public void delete(String episodeCode, String seriesCode) {
        Map<String, String> params = new HashMap<>();
        params.put("episodeCode", episodeCode);
        params.put("seriesCode", seriesCode);
        seriesProgramMappingDAO.delete(params);
    }

    @Override
    public List getAll(ModelSetup setup) {
        return seriesProgramMappingDAO.selectAll(setup);
    }

    @Override
    public String getCurSerial(String seriesCode) {
        return seriesProgramMappingDAO.getCurSerial(seriesCode);
    }
}
