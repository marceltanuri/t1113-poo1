package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.controller.command.FilmeCommand;
import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class ListarTodosFilmes extends FilmeCommand {


    public ListarTodosFilmes(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        repository.listarTodos().forEach((System.out::println));
    }
}
