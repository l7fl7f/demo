package com.springboot.c2.service;

import com.springboot.c2.dao.MovieDAO;
import com.springboot.c2.entity.Movie;
import com.springboot.c2.utils.ModelSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public void insert(Movie movie) {
        movieDAO.insert(movie);
    }

    @Override
    public void update(Movie movie) {
        movieDAO.updateByCode(movie);
    }

    @Override
    public void delete(String code) {
        movieDAO.delete(code);
    }

    @Override
    public List getAll(ModelSetup setup) {
        return movieDAO.selectAll(setup);
    }

    @Override
    public List selectByProgram(ModelSetup setup) {
        return movieDAO.selectByProgram(setup);
    }

    @Override
    public List selectBySeries(ModelSetup setup) {
        return movieDAO.selectBySeries(setup);
    }
}
