package com.mtanuri.t1113.exception;

import com.mtanuri.t1113.repository.FilmesRepository;

public class FilmeNotFoundException extends RuntimeException{

    public FilmeNotFoundException(Long id){
        super("Filme não encontrado com o ID: " + id);
    }
}
