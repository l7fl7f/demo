package com.springboot.c2.service;

import com.springboot.c2.dao.SeriesDAO;
import com.springboot.c2.entity.Series;
import com.springboot.c2.utils.ModelSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService implements ISeriesService {
    @Autowired
    private SeriesDAO seriesDAO;

    @Override
    public void insert(Series series) {
        seriesDAO.insert(series);
    }

    @Override
    public void update(Series series) {
        seriesDAO.updateByCode(series);
    }

    @Override
    public void delete(String code) {
        seriesDAO.delete(code);
    }

    @Override
    public List getAll(ModelSetup setup) {
        return seriesDAO.selectAll(setup);
    }

}
