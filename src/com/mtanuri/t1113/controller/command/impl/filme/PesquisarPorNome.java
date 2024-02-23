package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class PesquisarPorNome extends FilmeCommand {
    public PesquisarPorNome(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        String keywords = (String) params.get("keywords");
        repository.pesquisarPorNome(keywords).forEach(System.out::println);

    }
}
