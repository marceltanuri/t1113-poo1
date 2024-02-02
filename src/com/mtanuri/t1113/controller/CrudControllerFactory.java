package com.mtanuri.t1113.controller;

import com.mtanuri.t1113.model.Ator;
import com.mtanuri.t1113.model.Diretor;
import com.mtanuri.t1113.model.Filme;
import com.mtanuri.t1113.repository.CrudRepository;

import java.util.Objects;

public class CrudControllerFactory {

    private static CrudController<Filme> filmeCrudController;

    private static CrudController<Ator> atorCrudController;

    private static CrudController<Diretor> diretorCrudController;

    public static CrudController<Filme> getFilmeController(CrudRepository<Filme> filmesRepository) {
        if (Objects.isNull(filmeCrudController)) {
            filmeCrudController = new CrudController<>(filmesRepository);
        }
        return filmeCrudController;
    }


    public static CrudController<Ator> getAtorController(CrudRepository<Ator> atorRepository) {
        if (Objects.isNull(atorCrudController)) {
            atorCrudController = new CrudController<>(atorRepository);
        }
        return atorCrudController;
    }


    public static CrudController<Diretor> getDiretorController(CrudRepository<Diretor> diretorRepository) {
        if (Objects.isNull(atorCrudController)) {
            diretorCrudController = new CrudController<>(diretorRepository);
        }
        return diretorCrudController;
    }

}
