package com.mtanuri.ada.t1113.app;

import com.mtanuri.ada.t1113.controller.CrudController;
import com.mtanuri.ada.t1113.controller.CrudControllerFactory;
import com.mtanuri.ada.t1113.dto.CrudDTO;
import com.mtanuri.ada.t1113.dto.FilmeDTO;
import com.mtanuri.ada.t1113.model.Filme;
import com.mtanuri.ada.t1113.repository.FilmesRepository;
import com.mtanuri.ada.t1113.repository.impl.FilmesRepositoryFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FilmesRepository filmeRepository = FilmesRepositoryFactory.getInstance();
        CrudController<Filme> filmeController = CrudControllerFactory.getFilmeController(filmeRepository);

        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setId(1L);
        filmeDTO.setTitulo("A lagoa azul");


        filmeController.inserir(filmeDTO);


        filmeDTO = new FilmeDTO();
        filmeDTO.setId(2L);
        filmeDTO.setTitulo("A lagoa azul 2");


        filmeController.inserir(filmeDTO);

        List<CrudDTO<Filme>> todosFilmes = filmeController.listarTodos(FilmeDTO.class);
        todosFilmes.forEach(System.out::println);
        System.out.printf("Total de filmes cadastrados: %s\n\n", todosFilmes.size());

        FilmeDTO aExcluir = new FilmeDTO();
        aExcluir.setId(1L);

        filmeController.excluir(aExcluir);

        todosFilmes = filmeController.listarTodos(FilmeDTO.class);
        System.out.printf("Total de filmes cadastrados: %s", todosFilmes.size());


    }

}
