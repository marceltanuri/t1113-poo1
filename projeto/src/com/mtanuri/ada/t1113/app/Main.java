package com.mtanuri.ada.t1113.app;

import com.mtanuri.ada.t1113.controller.CrudController;
import com.mtanuri.ada.t1113.controller.CrudControllerFactory;
import com.mtanuri.ada.t1113.dto.CrudDTO;
import com.mtanuri.ada.t1113.dto.FilmeDTO;
import com.mtanuri.ada.t1113.model.Filme;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CrudController<Filme> filmeController = CrudControllerFactory.getInstance(Filme.class);

        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setId(1L);
        filmeDTO.setTitulo("A lagoa azul");


        filmeController.inserir(filmeDTO);


        filmeDTO = new FilmeDTO();
        filmeDTO.setId(2L);
        filmeDTO.setTitulo("A lagoa azul 2");


        filmeController.inserir(filmeDTO);

        filmeController = CrudControllerFactory.getInstance(Filme.class);


        List<CrudDTO<Filme>> todosFilmes = filmeController.listarTodos(FilmeDTO.class);
        todosFilmes.forEach(System.out::println);
        System.out.printf("Total de filmes cadastrados: %s\n\n", todosFilmes.size());

        FilmeDTO aExcluir = new FilmeDTO();
        aExcluir.setId(1L);

        filmeController.excluir(aExcluir);

        filmeController = CrudControllerFactory.getInstance(Filme.class);


        todosFilmes = filmeController.listarTodos(FilmeDTO.class);
        System.out.printf("Total de filmes cadastrados: %s", todosFilmes.size());


    }

}
