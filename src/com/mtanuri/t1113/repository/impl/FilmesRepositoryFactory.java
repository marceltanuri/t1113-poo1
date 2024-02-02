package com.mtanuri.t1113.repository.impl;

import com.mtanuri.t1113.repository.FilmesRepository;

public class FilmesRepositoryFactory {

    private static FilmesRepository filmesRepository;

    public static FilmesRepository getInstance(){
        if(filmesRepository==null){
            filmesRepository = new FilmesRepositoryInMemoryImpl();
        }
        return filmesRepository;
    }

}
