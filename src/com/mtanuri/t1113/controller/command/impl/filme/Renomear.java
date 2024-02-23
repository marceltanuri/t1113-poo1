package com.mtanuri.t1113.controller.command.impl.filme;

import com.mtanuri.t1113.repository.FilmeRepository;

import java.util.Map;

public class Renomear extends FilmeCommand {
    public Renomear(FilmeRepository repository) {
        super(repository);
    }

    @Override
    public void executar(Map<String, Object> params) {
        int idFilme = (int) params.get("idFilme");
        String nome = (String) params.get("nome");
        repository.renomear(idFilme, nome);
    }
}
