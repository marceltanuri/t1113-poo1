package com.mtanuri.ada.t1113.exception;

public class FilmeNotFoundException extends RuntimeException{

    public FilmeNotFoundException(Long id){
        super("Filme não encontrado com o ID: " + id);
    }
}
